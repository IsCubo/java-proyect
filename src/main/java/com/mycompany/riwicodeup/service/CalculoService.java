/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.domain.Nota;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Coder
 */
public class CalculoService {
   
    public static double promedio(List<Nota> notas) {
        
        double promedio, notaTotal = 0;
        for (Nota nota : notas) {
            notaTotal += nota.getValor();
        }
        
        promedio = notaTotal/notas.size();
        return promedio;
    }
    
    public static Nota notaMaxima(List<Nota> notas) {
        return notas.stream()
            .max(Comparator.comparingDouble(Nota::getValor))
                .orElse(null);
    }
    
    public static boolean aprobado(double promedio) {
        return promedio >= 3.0;
    }
    
    
}
