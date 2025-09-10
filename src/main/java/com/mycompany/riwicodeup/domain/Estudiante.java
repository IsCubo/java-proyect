/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Coder
 */
public class Estudiante {

    private String nombre;
    private int edad;
    private double nota1, nota2, nota3;

    public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Calcula el promedio de las tres notas
    public double calcularPromedio() {
        if (nota1 <= 0 && nota1 >= 5
                && nota2 <= 0 && nota2 >= 5
                && nota3 <= 0 && nota3 >= 5) {
            JOptionPane.showMessageDialog(null, "Notas fuera de rango.", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
        
        
            return (nota1 + nota2 + nota3) / 3.0;
        }
        // Devuelve la nota más alta
    public double notaMaxima() {
        return Math.max(nota1, Math.max(nota2, nota3));
    }

// Indica si el estudiante está aprobado (promedio >= 3.0)
    public boolean estaAprobado() {
        return calcularPromedio() >= 3.0;
    }
}
