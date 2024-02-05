package org.example.SpringSem2Ex4.controllers;


import org.example.SpringSem2Ex4.model.User;
import org.example.SpringSem2Ex4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(User user){
        userService.deleteById(user.getId());
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String getUser(User user){
        User user1 = userService.getUser(user.getId());
        user.setId(user1.getId());
        user.setFirstName(user1.getFirstName());
        user.setLastName(user1.getLastName());
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}