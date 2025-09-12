/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.domain.service;

import com.mycompany.riwicodeup.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Coder
 */
public class LoginUserService {

    private static final List<User> users = new ArrayList<>();

    public static void AddUserDefault() {
        boolean exists = users.stream()
                .anyMatch(u -> u.getUsername().equals("admin"));
        if (!exists) {
            User newUser = new User(UUID.randomUUID().toString(), "admin", "admin123");
            users.add(newUser);
        }
    }

    public static List<User> ListUsers() {
        return users;
    }

    public static boolean AuthLogin(String username, String password) {
        AddUserDefault();
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }
    
}
