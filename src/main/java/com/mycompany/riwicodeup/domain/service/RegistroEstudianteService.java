/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.domain.service;

import com.mycompany.riwicodeup.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Coder
 */
public class RegistroEstudianteService {
    private static final List<Estudiante> estudiantes = new ArrayList<>();
    
    public static List<Estudiante> listarEstudiantes() {
        return estudiantes;
    }
    
    public void agregarEstudiante(Estudiante e) { 
        estudiantes.add(e);
    }
    
    /*
    public double calcularPromedioGeneral() { ... }
    public Optional<Estudiante> mejorEstudiante() { ... }
    public long contarAprobados() { ... }
    public long contarReprobados() { ... }*/
}
