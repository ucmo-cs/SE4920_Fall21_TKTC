package com.FedReserve.FederalReserveProject.repository;

import com.FedReserve.FederalReserveProject.model.Events;
import com.FedReserve.FederalReserveProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /*
    @Query(value = "SELECT * FROM user WHERE name = 'bob'", nativeQuery = true)
    User test();

    @Query(value = "SELECT * FROM user WHERE employee_name = ?1", nativeQuery = true)
    User findByFirstName(String name);

    //@Query(value = "SELECT events.id, date, description, emails, location, name, events.team_id   FROM events INNER JOIN user ON (user.team_id = events.team_id) AND (user.uid = :uid)", nativeQuery = true)
    @Query(value = "SELECT * FROM events LEFT JOIN user ON (user.team_id = events.team_id) AND (user.uid = :uid);", nativeQuery = true)
    List<Events> findUserEvents(@Param("uid") int uid);
    */
}