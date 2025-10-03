
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.domain.Estudiante;
import com.mycompany.riwicodeup.db.EstudianteDAO;
import com.mycompany.riwicodeup.domain.Nota;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Coder
 */
public class RegistroEstudianteService {

    private static List<Estudiante> estudiantes = new ArrayList<>();

    public static List<Estudiante> listarEstudiantes() throws SQLException {
        return EstudianteDAO.listar();
    }

    public void agregarEstudiante(Estudiante e) throws SQLException {      
        EstudianteDAO.guardar(e);
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

    public double calcularPromedioGeneral() throws SQLException {
        double promedioGeneral = EstudianteDAO.listar().stream()
                .flatMap(est -> est.getNotas().stream())
                .mapToDouble(Nota::getValor)
                .average()
                .orElse(0.0);
        return promedioGeneral;
    }
    
    public Optional<Estudiante> mejorEstudiante() throws SQLException {
        return EstudianteDAO.listar().stream()
                .max(Comparator.comparing(est -> CalculoService.promedio(est.getNotas())
                ));
    }
    public long contarAprobados() throws SQLException { 
        long aprovados = EstudianteDAO.listar().stream()
                .filter(est -> CalculoService.aprobado(CalculoService.promedio(est.getNotas())))
                .count();
        return aprovados;
    }
    public long contarReprobados() throws SQLException { 
        long reprobados = EstudianteDAO.listar().stream()
                .filter(est -> !CalculoService.aprobado(CalculoService.promedio(est.getNotas())))
                .count();
        return reprobados;
    }
    
    public static void eliminarEstudiante(int id) throws SQLException{
        EstudianteDAO.eliminar(id);
    }
    
    public static void actualizarEstudiante(Estudiante e) throws SQLException {
        EstudianteDAO.actualizar(e);
    }
}
