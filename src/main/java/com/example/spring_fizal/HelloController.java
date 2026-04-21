package com.example.spring_fizal;

import com.example.spring_fizal.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
public class HelloController {

    @GetMapping ("/message")
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/user")
    public User get(){
        User user = new User(1,"Sanketh" , "sanketh@gmail.com");
        return user;
    }
}
