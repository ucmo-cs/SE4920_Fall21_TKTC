package com.example.federalreserve.domain;

import javax.persistence.*;

@Entity
public class Guidances {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guid;

    private int posterID;
    private String guidanceName;
    private String guidanceDesc;


    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    public int getPosterID() {
        return posterID;
    }

    public void setPosterID(int posterID) {
        this.posterID = posterID;
    }

    public String getGuidanceName() {
        return guidanceName;
    }

    public void setGuidanceName(String guidanceName) {
        this.guidanceName = guidanceName;
    }

    public String getGuidanceDesc() {
        return guidanceDesc;
    }

    public void setGuidanceDesc(String guidanceDesc) {
        this.guidanceDesc = guidanceDesc;
    }
}
