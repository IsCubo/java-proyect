/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.domain;

import java.util.List;

/**
 *
 * @author Coder
 */
public class Estudiante {
    private final String id;
    private String nombre;
    private int edad;
    private List<Nota> notas;

    public Estudiante(String id, String nombre, int edad, List<Nota> notas) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", notas=" + notas + '}';
    }

}
