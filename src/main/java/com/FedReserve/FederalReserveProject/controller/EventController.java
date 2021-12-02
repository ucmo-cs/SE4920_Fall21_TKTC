package com.FedReserve.FederalReserveProject.controller;

import com.FedReserve.FederalReserveProject.model.Events;
import com.FedReserve.FederalReserveProject.repository.EventRepository;
import com.FedReserve.FederalReserveProject.service.EventService;
import com.FedReserve.FederalReserveProject.vo.RequestEvent;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/event")
    public String addEvent(@RequestBody RequestEvent requestEvent, String title, LocalDate start) {
        System.out.println("addEvent in EventController");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Events event = mapper.map(requestEvent,Events.class);

        int id = 1;
        System.out.println("start: " + start);
        System.out.println("id: " + event.getId());
        System.out.println("date: " + event.getDate());
        System.out.println("desc: " + event.getDescription());
        System.out.println("emails: " + event.getEmails());
        System.out.println("location: " + event.getLocation());
        System.out.println("name: " + event.getName());
        System.out.println("team_id: " + event.getTeam_id());

        eventService.add(event);//id, title, start);
        System.out.println("A new event has been added");
        return "New event added";
    }

    //@GetMapping("/event/{id}")
    /*public Events getEvent(@RequestBody RequestEvent requestEvent) {
        return eventService.getEvent("1");
    }*/
    @GetMapping("/event")
    public ResponseEntity<?> getEvent() {
        //return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
        return new ResponseEntity<>(eventService.getEvent(), HttpStatus.OK);
    }

    @PostMapping("/event/delete/{id}")
    public void deleteEvent(@PathVariable int id, @RequestBody RequestEvent requestEvent) {
        System.out.println("deleteEvent in EventController");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Events event = mapper.map(requestEvent,Events.class);
        eventService.deleteEvent(event);
    }
}
