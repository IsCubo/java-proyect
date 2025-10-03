/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.db.UsuarioDao;
import com.mycompany.riwicodeup.domain.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Coder
 */
public class LoginUserService {

    private static final List<User> users = new ArrayList<>();

    public static boolean AuthLogin(String username, String password) throws SQLException {
        /*return users.stream()
        .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));*/
        User u = new User(UUID.randomUUID().toString(),username, password);
        return UsuarioDao.login(u);
    }
    
}
