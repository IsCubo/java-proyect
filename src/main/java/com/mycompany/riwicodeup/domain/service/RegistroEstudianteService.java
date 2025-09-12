/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.domain.service;

import com.mycompany.riwicodeup.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Coder
 */
public class RegistroEstudianteService {

    private static List<Estudiante> estudiantes = new ArrayList<>();

    public static List<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void agregarEstudiantes(List<Estudiante> estudiantes) {
        Map<String, Estudiante> mapaEstudiantes = estudiantes.stream()
                .collect(Collectors.toMap(Estudiante::getId, e -> e));

        for (Estudiante estudiante : this.estudiantes) {
            mapaEstudiantes.putIfAbsent(estudiante.getId(), estudiante);
        }

        this.estudiantes = new ArrayList<>(mapaEstudiantes.values());
    }

    public void reemplazarEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    /*
    public double calcularPromedioGeneral() { ... }
    public Optional<Estudiante> mejorEstudiante() { ... }
    public long contarAprobados() { ... }
    public long contarReprobados() { ... }*/
}
