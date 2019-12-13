package com.sprintflow.lesson22.task2.controller;

import com.sprintflow.lesson22.task2.model.User;
import com.sprintflow.lesson22.task2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        List<User> users = userRepository.getAll();
        return users.stream()
                //.map(User::getFirstName)
                .map(user -> user.getFirstName() + " " + user.getLastName() + " " + user.getAge())
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("imie") String name, @RequestParam("nazwisko") String lastName, @RequestParam("wiek") int age) {
        if (name.isEmpty()) {
            return "redirect:/err.html";
        }
        User user = new User(name, lastName, age);
        userRepository.add(user);
        return "redirect:success.html";
    }

    @PostMapping("/findUser")
    @ResponseBody
    public String findUser(@RequestParam("userDetail") String userDetail) {
        List<User> users = userRepository.getAll();

        String foundUsers = users.stream()
                .filter(user -> user.getFirstName().equals(userDetail) || user.getLastName().equals(userDetail) || String.valueOf(user.getAge()).equals(userDetail))
                .map(user -> user.getFirstName() + " " + user.getLastName() + " " + user.getAge())
                .collect(Collectors.joining(", ", "[", "]"));

        if (foundUsers.equals("[]")) {
            return "Nie znaleziono użytkownika";
        } else {
            return foundUsers;
        }
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam(name = "firstName", required = false) String firstName,
                             @RequestParam(name = "lastName", required = false) String lastName,
                             @RequestParam(name = "age", required = false) String age) {


        List<User> users = userRepository.getAll();

        List<User> usersList = users.stream()
                .filter(user -> user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && String.valueOf(user.getAge()).equals(age))
                .collect(Collectors.toList());

        userRepository.remove(usersList);

        return "Usunięto: " + usersList;
    }
}