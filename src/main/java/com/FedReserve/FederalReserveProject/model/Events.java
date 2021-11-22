package com.FedReserve.FederalReserveProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String description;
    private String location;
    private String emails;
    private int team_id;

    public Events() {
    }

//    public Events(String name, LocalDate date, String description, String location, String emails, int team_id) {
//        this.name = name;
//        this.date = date;
//        this.description = description;
//        this.location = location;
//        this.emails = emails;
//        this.team_id = team_id;
//    }

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

    public String getDate() {
        return date;
    }

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

/*
To create dummy database info, use these statements

INSERT INTO events VALUES(1, '2020-11-15', "Meeting at 1pm", "bobmason@company.net", "Meeting Room One", "Mandatory Meeting", 1);
INSERT INTO events VALUES(2, '2020-11-16', "Meeting at 11am", "alexandersmith@company.net", "Meeting Room Three", "Mandatory Meeting", 2);
*/