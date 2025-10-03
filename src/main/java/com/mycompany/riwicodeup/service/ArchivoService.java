package com.mycompany.riwicodeup.service;

import com.mycompany.riwicodeup.domain.Estudiante;
import com.mycompany.riwicodeup.domain.Nota;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.TableModel;

public class ArchivoService {

    public static void guardarCSV(Component parent, JTable tabla) throws SQLException {
        JFileChooser archivoCsv = new JFileChooser();
        archivoCsv.setDialogTitle("Guardar archivo como CSV");
        int selection = archivoCsv.showSaveDialog(parent);

        if (selection == JFileChooser.APPROVE_OPTION) {
            File archivo = archivoCsv.getSelectedFile();

            // Agrega la extensión .csv si no está
            if (!archivo.getName().toLowerCase().endsWith(".csv")) {
                archivo = new File(archivo.getAbsolutePath() + ".csv");
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                List<Estudiante> estudiantes = RegistroEstudianteService.listarEstudiantes();

                pw.println("Id, Nombre, Edad, Nota1, Nota2, Nota3");
                for (Estudiante e : estudiantes) {
                    String notasStr = e.getNotas().stream()
                            .map(notas -> String.valueOf(notas.getValor()))
                            .collect(Collectors.joining(","));

                    pw.printf("%s,%s,%d,%s%n",
                            e.getId(),
                            e.getNombre(),
                            e.getEdad(),
                            notasStr
                    );
                }

                pw.flush();
                JOptionPane.showMessageDialog(parent, "Archivo CSV guardado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parent, "Error al guardar el archivo: " + e.getMessage());
            }
        }
    }

    public static void cargarCSV(JFrame parent, boolean reemplazar) {
        JFileChooser archivoCsv = new JFileChooser();
        archivoCsv.setDialogTitle("Seleccionar archivo CSV");
        int seleccion = archivoCsv.showOpenDialog(parent);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = archivoCsv.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                List<Estudiante> estudiantes = new ArrayList<>();
                String linea;
                boolean esPrimeraLinea = true;

                while ((linea = reader.readLine()) != null) {
                    if (esPrimeraLinea) {
                        esPrimeraLinea = false;
                        continue; // Saltar la cabecera
                    }

                    String[] datos = linea.split(",");
                    if (datos.length != 6) {
                        throw new IllegalArgumentException("Formato incorrecto en la línea: " + linea);
                    }

                    String id = datos[0];
                    String nombre = datos[1];
                    int edad = Integer.parseInt(datos[2]);
                    double nota1 = Double.parseDouble(datos[3]);
                    double nota2 = Double.parseDouble(datos[4]);
                    double nota3 = Double.parseDouble(datos[5]);

                    Nota n1 = new Nota(nota1);
                    Nota n2 = new Nota(nota2);
                    Nota n3 = new Nota(nota3);

                    Estudiante estudiante = new Estudiante(id, nombre, edad, Arrays.asList(n1, n2, n3));
                    estudiantes.add(estudiante);
                }

                RegistroEstudianteService registroService = new RegistroEstudianteService();
                if (reemplazar) {
                    registroService.reemplazarEstudiantes(estudiantes);
                } else {
                    registroService.agregarEstudiantes(estudiantes);
                }

                JOptionPane.showMessageDialog(parent, "Datos cargados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | IllegalArgumentException e) {
                JOptionPane.showMessageDialog(parent, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
