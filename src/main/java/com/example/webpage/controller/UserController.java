package com.example.webpage.controller;

import com.example.webpage.entities.User;
import com.example.webpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UserController{

    @Autowired
    private UserRepository repository;

    @GetMapping
    public String start(){
        return "demo";
    }

    @GetMapping("/login")
    public String setUser(String name,String email,String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        repository.save(user);
        return "Login";
    }

    @GetMapping("/delete_page")
    public String delete(){
        return "delete";
    }

    @GetMapping("/delete")
    public String deleteUser(int id){
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
        }
        return "Login";
    }
}
