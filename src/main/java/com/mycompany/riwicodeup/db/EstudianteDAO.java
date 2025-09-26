/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.db;

import com.mycompany.riwicodeup.domain.Estudiante;
import com.mycompany.riwicodeup.domain.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Coder
 */
public class EstudianteDAO {
    
    public void guardar(Estudiante e) throws SQLException{
        
        String sql = "INSERT INTO estudiante (nombre, edad, nota1, nota2, nota3) VALUES (?,?,?,?,?)";
        
        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getEdad());
            ps.setDouble(3, e.getNotas().get(0).getValor());
            ps.setDouble(4, e.getNotas().get(1).getValor());
            ps.setDouble(5, e.getNotas().get(2).getValor());
            ps.execute();
        }
    }

    public List<Estudiante> listar() throws SQLException{
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";
        
        try(Connection conn = ConexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                int id = rs.getInt("id");
                String idStr = Integer.toString(id);
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                Nota nota1 = new Nota(rs.getDouble("nota1"));
                Nota nota2 = new Nota(rs.getDouble("nota2"));
                Nota nota3 = new Nota(rs.getDouble("nota3"));
                estudiantes.add(new Estudiante(idStr, nombre, edad, List.of(nota1, nota2, nota3)));
            }
        }
        return estudiantes;
    }
}
