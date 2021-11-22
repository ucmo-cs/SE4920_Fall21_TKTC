package com.FedReserve.FederalReserveProject.service;

import com.FedReserve.FederalReserveProject.model.User;
import com.FedReserve.FederalReserveProject.repository.EventRepository;
import com.FedReserve.FederalReserveProject.model.Events;
import jdk.jfr.Event;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventServiceImplementation implements EventService{

    @Autowired
    private EventRepository eventRepository;

    //@Override
    //public Events add(int id, String title, Date start) {
    public Events add(Events event){
        return eventRepository.save(event);//id, start, "desc", "email", "location", title, 1);
        //id	date	description	emails	location	name	team_id
    }

    public Events getEvent(String id){
        return eventRepository.getById(id);
    }

    public void deleteEvent(Events event) {
        eventRepository.delete(event);
    }
}
