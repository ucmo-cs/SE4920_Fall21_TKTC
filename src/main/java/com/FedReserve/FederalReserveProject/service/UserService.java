package com.FedReserve.FederalReserveProject.service;

import com.FedReserve.FederalReserveProject.model.User;
import com.FedReserve.FederalReserveProject.vo.Login;
//import com.FedReserve.FederalReserveProject.model.Events;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();

    public boolean validateUserLogin(Login login);
    //public List<Events> getUserEvents(User user);
}
