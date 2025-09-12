/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

/**
 *
 * @author Coder
 */
public class Validator {
    // Validar si un campo está vacío
    public static boolean campoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    // Validar formato de email básico
    public static boolean esEmailValido(String email) {
        if (campoVacio(email)) return false;
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // Validar si es número entero
    public static boolean esNumero(String texto) {
        if (campoVacio(texto)) return false;
        return texto.matches("\\d+");
    }

    // Validar rango numérico (inclusive)
    public static boolean estaEnRango(int valor, int min, int max) {
        return valor >= min && valor <= max;
    }
}
