package com.FedReserve.FederalReserveProject.service;

import com.FedReserve.FederalReserveProject.model.Events;
import com.FedReserve.FederalReserveProject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface EventService {
    public Events add(Events event);
    public List<Events> getEvent();
    //public void deleteEvent(int id);
    public void deleteEvent(Events event);
}
