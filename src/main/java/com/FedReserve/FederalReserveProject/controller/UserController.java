package com.FedReserve.FederalReserveProject.controller;

import com.FedReserve.FederalReserveProject.model.Events;
import com.FedReserve.FederalReserveProject.model.User;
import com.FedReserve.FederalReserveProject.service.SecurityService;
import com.FedReserve.FederalReserveProject.service.UserService;
import com.FedReserve.FederalReserveProject.repository.UserRepository;
import com.FedReserve.FederalReserveProject.vo.Login;
import com.FedReserve.FederalReserveProject.vo.RequestUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/add")
    @CrossOrigin
    public String add(@RequestBody RequestUser requestUser) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        User user = mapper.map(requestUser,User.class);
        userService.saveUser(user);
        System.out.println("User (" + user.getUsername() + ") has been added");
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/login")
    @CrossOrigin
    public ResponseEntity<Map<String,Object>> validateUserLogin(@RequestBody Login login) {
        System.out.println("Login Server TEST");
        System.out.println(login.getUsername());
        System.out.println(login.getPassword());

        String token = securityService.createToken(login.getUsername(),(1*1000*10));
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("token", token);

        System.out.println("token" + token);

        System.out.println("Validation "+ userService.validateUserLogin(login));

        if (userService.validateUserLogin(login)) {
            return ResponseEntity.status(200).body(map);
        }
        return ResponseEntity.status(400).body(null);

    }


}
