package com.FedReserve.FederalReserveProject.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

//@Data
@Entity
public class RequestEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //private LocalDate date;
    private String date;
    private String description;
    private String location;
    private String emails;
    private int team_id;

    public RequestEvent() {
    }

    public RequestEvent(int id, String name, String date, String description, String location, String emails, int team_id) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.location = location;
        this.emails = emails;
        this.team_id = team_id;
        System.out.println("constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {return date;}

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
