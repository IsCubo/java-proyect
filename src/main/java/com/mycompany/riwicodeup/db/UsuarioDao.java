/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.db;

import com.mycompany.riwicodeup.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Coder
 */
public class UsuarioDao {

    public static boolean register(User u) throws SQLException {
        String sqlCheck = "SELECT username FROM usuarios WHERE username = ?";

        try (Connection conn = ConexionDB.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sqlCheck)) {
            ps.setString(1, u.getUsername());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }

            String sqlCreate = "INSERT INTO usuarios (username, password) VALUES (?,?)";
            try (PreparedStatement psInsert = conn.prepareStatement(sqlCreate)) {
                psInsert.setString(1, u.getUsername());
                psInsert.setString(2, u.getPassword()); 
                psInsert.executeUpdate();
                return true;
            }
        }
    }
    
    public static boolean login(User u) throws SQLException{
        String sql = "SELECT username, password FROM usuarios WHERE username = ? AND password = ?";
        
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, u.getUsername());
                ps.setString(2, u.getPassword());
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()) return true;
        }
        
        return false;
    }
}
