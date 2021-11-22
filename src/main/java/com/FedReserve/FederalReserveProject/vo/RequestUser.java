package com.FedReserve.FederalReserveProject.vo;

import lombok.Data;

@Data
public class RequestUser {

    private String username;
    private String password;
    private String employee_name;
    private String email;
    private int team_id;
}
