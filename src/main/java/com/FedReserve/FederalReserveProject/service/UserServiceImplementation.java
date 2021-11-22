package com.FedReserve.FederalReserveProject.service;

//import com.FedReserve.FederalReserveProject.model.Events;
import com.FedReserve.FederalReserveProject.dto.UserDto;
import com.FedReserve.FederalReserveProject.model.User;
import com.FedReserve.FederalReserveProject.repository.UserRepository;
import com.FedReserve.FederalReserveProject.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public boolean validateUserLogin(Login login) {
        Optional<User> user = userRepository.findById(login.getUsername());
        if (!user.isPresent()) {
            return false;
        }
        System.out.println("login pass " + login.getPassword());
        System.out.println("database pass " + user.get().getPassword());

        return login.getPassword().equals(user.get().getPassword());
    }

    /*@Override
    public List<Events> getUserEvents(User user) {
        //Go through events table and search for user's email,
        //then add the event to a list to be returned.
    }*/
}
