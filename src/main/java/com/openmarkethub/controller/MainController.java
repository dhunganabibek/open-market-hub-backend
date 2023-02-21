package com.openmarkethub.controller;

import com.openmarkethub.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/user")
    public UserDTO getUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUsername("bd4757");
        userDTO.setPassword("Password1");
        return userDTO;

    }

}
