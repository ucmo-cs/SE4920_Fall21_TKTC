package com.FedReserve.FederalReserveProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int uid;

    @Id
    private String username;
    private String password;
    private String employee_name;
    private String email;
    private int team_id;


}


/*
To create dummy database info, use these statements

INSERT INTO user VALUES (1,"bobmason@company.net", "Bob Mason", "cheese123", 1, "bobmason");
INSERT INTO user VALUES (2,"georgelincoln@company.net", "George Lincoln", "apple456", 1, "georgelincoln");
INSERT INTO user VALUES (3,"stephanyeldridge@company.net", "Stephany Eldridge", "skateboard", 1, "stephanyeldridge");
INSERT INTO user VALUES (4,"johndoe@company.net", "John Doe", "annonymous", 2, "johndoe");
INSERT INTO user VALUES (5,"alexandersmith@company.net", "Alexander Smith", "yummyfood", 2, "alexandersmith");
*/