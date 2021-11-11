package com.example.federalreserve.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Events {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    private String eventName;
    private Date eventDate;
    private String eventDescription;
    private String eventLocation;
    private String inviteeEmails;
    private String eventTeam;

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getInviteeEmails() {
        return inviteeEmails;
    }

    public void setInviteeEmails(String inviteeEmails) {
        this.inviteeEmails = inviteeEmails;
    }

    public String getEventTeam() {
        return eventTeam;
    }

    public void setEventTeam(String eventTeam) {
        this.eventTeam = eventTeam;
    }
}
