package com.FedReserve.FederalReserveProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Guidances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guidance_id;
    private int poster_id;
    private String guidance_name;
    private String guidance_desc;

    public Guidances() {
    }

    public int getGuidance_id() {
        return guidance_id;
    }

    public void setGuidance_id(int guidance_id) {
        this.guidance_id = guidance_id;
    }

    public int getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }

    public String getGuidance_name() {
        return guidance_name;
    }

    public void setGuidance_name(String guidance_name) {
        this.guidance_name = guidance_name;
    }

    public String getGuidance_desc() {
        return guidance_desc;
    }

    public void setGuidance_desc(String guidance_desc) {
        this.guidance_desc = guidance_desc;
    }
}

/*
To create dummy database info, use these statements

INSERT INTO guidances VALUES (1, "Generic description", "Generic name", 4);
INSERT INTO guidances VALUES (2, "Generic description 2", "Generic name 2", 4);
*/