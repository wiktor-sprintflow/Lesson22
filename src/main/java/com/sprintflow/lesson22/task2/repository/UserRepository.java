package com.sprintflow.lesson22.task2.repository;

import com.sprintflow.lesson22.task2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User ("Marcin","Kowalski", 11));
        users.add(new User ("Marcin","Kowalski", 11));
        users.add(new User ("Ala","Marcin", 30));
        users.add(new User ("Tomek","Malinowski", 80));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public void remove(List<User> usersList) {
        for (User user : usersList) {
            users.remove(user);
        }
    }


}
