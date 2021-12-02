//Move these over

import axios from 'axios'
import React,{Component} from 'react'
import FullCalendar from '@fullcalendar/react' // must go before plugins
import dayGridPlugin from '@fullcalendar/daygrid' // a plugin!
import timeGridPlugin from '@fullcalendar/timegrid';
import { createRef } from 'react';
import interactionPlugin from '@fullcalendar/interaction';

class CalendarForm extends Component {
  state = {eventList: [{id: '', name: '', date: '', description: '', location: '', emails: '', team_id: ''}]}

  handleDateSelect = (selectInfo) => {
  let input = prompt('Do you want to Add/Edit the event? (Y/N)')
        if (input === 'Y') {
            let title = prompt('Please enter a new title for your event')
            let eventDescription = prompt('Please enter a description of your event')
            let eventLocation = prompt('Please enter the location of your event')
            let calendarApi = selectInfo.view.calendar
 
            calendarApi.unselect()

            if (title) {
                const eventNew = {id: "0", name: title, date: selectInfo.startStr, description: eventDescription, location: eventLocation, emails: "emails", team_id: "1"}
                                this.setState({ ...this.state, eventList: [...this.state.eventList, eventNew] }, () => {
                                    console.log("hi");
                                });
                //console.log(this.state)
                console.log(eventNew)
                console.log("(" + selectInfo.startStr + ")")
                axios.post("http://localhost:8080/event", eventNew).then(
                    (res) => {
                        console.log("inside ")
                        window.location.reload();
                    }
                ).catch(error => {
                    console.log(error.message)
                })
 
            }
            else if (input === 'N') {
                console.log("hi")
            }
 
        }
 
    }
    componentDidMount() {
 
        axios.get("http://localhost:8080/event").then((res) => {
            this.setState({ eventList: res.data })
 
        })
    }
    renderEventContent = (eventInfo) => {
        //const newEvent = { title: '', start: '' }
        const newEvent = {eventList: [{id: ''}]}

        const onEventDelete = () => {
            const newEvent = {id: "0"}
                                            this.setState({ ...this.state, eventList: [...this.state.eventList, newEvent] }, () => {
                                                console.log("hi");
                                            });
            const json = JSON.stringify({id: parseInt(eventInfo.event.id, 10) });
            console.log("json:");
            console.log(json);
            console.log("http://localhost:8080/event/delete/" + eventInfo.event.id);
            axios.post("http://localhost:8080/event/delete/" + eventInfo.event.id,json,
            {
              headers: {
                // Overwrite Axios's automatically set Content-Type
                'Content-Type': 'application/json'
              }
            }
            ).then((res) => {
                window.location.reload();
            })
        }

        const onEditEvent = () => {
            const newEvent = {id: "0"}
                this.setState({ ...this.state, eventList: [...this.state.eventList, newEvent] }, () => {
                    console.log("hello");
            });
            console.log("eventInfo")
            console.log(eventInfo.event._def.extendedProps.name)
            console.log("this.state.eventList:")
            console.log(this.state.eventList)
            console.log("this.state:")
            if(eventInfo.event.allDay)
            {
                console.log("ALL DAY BABY")
                alert(eventInfo.event._def.extendedProps.name + "\n" + eventInfo.event._def.extendedProps.description + "\n" + eventInfo.event._def.extendedProps.location + "\nTHIS IS AN ALL DAY EVENT")
            }
            else
            {
                var temp_date = eventInfo.event.start;
                var string_date = temp_date.getHours() + ":" + temp_date.getMinutes()
                if (temp_date.getMinutes().toString() == 0)
                    string_date += "0"
                alert(eventInfo.event._def.extendedProps.name + "\n" + eventInfo.event._def.extendedProps.description + "\n" + eventInfo.event._def.extendedProps.location + "\n" + string_date)
            }
        }
        return (
            <>
                {/* <div>
                    <b>{eventInfo.event._def.publicId}</b>
                </div> */}
                < div >
                    <b style={{ textTransform: 'uppercase' }}>{eventInfo.event._def.title}</b>
                </div >
                <div>
                    <button onClick={() => onEditEvent()}>View</button>
                </div>
                <div>
                    <button onClick={() => onEventDelete()}>Delete</button>
                </div>
            </>
        )
    }
   render(){   
  return (
    <div>
      <div>
          <FullCalendar
            // ref={calendarRef}
            plugins={[ dayGridPlugin, timeGridPlugin, interactionPlugin]}
            initialView="dayGridMonth"
            editable={true}
            selectable={true}
            selectMirror={true}
            dayMaxEvents={true}
            events={
                this.state.eventList
            }
            select={this.handleDateSelect}
            eventContent={this.renderEventContent} // custom render function
 
            headerToolbar={{
              left: "prev,next",
              center: "title",
              right: "today,timeGridDay,timeGridWeek,dayGridMonth"
            }}
      />
      
      </div>
    </div>
  );
          }
}
export default CalendarForm;