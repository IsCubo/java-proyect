/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.domain.User;
import java.util.List;

/**
 *
 * @author Coder
 */
public class RegisterUserService {

    private List<User> listUser = LoginUserService.ListUsers();

    public RegisterUserService() {
    }

    public boolean Register(User e) {
        if (listUser.stream()
                .anyMatch(u -> u.getUsername().equals(e.getUsername()))) {
            return false;
        }

        listUser.add(e);

        return true;
    }

}
