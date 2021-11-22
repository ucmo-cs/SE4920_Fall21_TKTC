package com.FedReserve.FederalReserveProject.dto;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private String employee_name;
    private String email;
    private int team_id;

}
