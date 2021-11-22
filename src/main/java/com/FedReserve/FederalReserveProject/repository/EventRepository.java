package com.FedReserve.FederalReserveProject.repository;

import com.FedReserve.FederalReserveProject.model.Events;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Events, String> {
    //@Query(value = "SELECT * FROM user WHERE employee_name = ?1", nativeQuery = true)
    //Events add(String name);
}
