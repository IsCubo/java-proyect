/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.db.UsuarioDao;
import com.mycompany.riwicodeup.domain.User;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Coder
 */
public class RegisterUserService {

    public static boolean Register(String username, String password) throws SQLException {
        User u = new User(UUID.randomUUID().toString(), username, password);
        return UsuarioDao.register(u);
    }
}
