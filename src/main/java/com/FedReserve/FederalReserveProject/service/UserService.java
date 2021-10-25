package com.FedReserve.FederalReserveProject.service;

import com.FedReserve.FederalReserveProject.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}
