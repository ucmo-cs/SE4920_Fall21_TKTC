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
            let calendarApi = selectInfo.view.calendar
 
            calendarApi.unselect()

            if (title) {
                const eventNew = {id: "0", name: title, date: selectInfo.startStr, description: "desc", location: "location", emails: "emails", team_id: "1"}
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
        const newEvent = { title: '', start: '' }
 
        const onEventDelete = () => {
            axios.delete("http://localhost:8080/event/" + eventInfo.event.id, newEvent).then((res) => {
                window.location.reload();
            })
        }
 
        const onEditEvent = () => {
 
            let title = prompt('Please enter a new title for your event')
            newEvent.title = title
 
            console.log(newEvent)
            if (title) {
                let newDate = prompt('Please enter a date (YYYY-MM-DD)')
                newEvent.start = newDate
                axios.put("http://localhost:8080/event/" + eventInfo.event.id, newEvent)
                    .then((res) => {
                        window.location.reload();
 
                        // eventInfo.history.push("http://localhost:3000/")
 
                    })
 
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
                    <button onClick={() => onEditEvent()}>Edit</button>
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