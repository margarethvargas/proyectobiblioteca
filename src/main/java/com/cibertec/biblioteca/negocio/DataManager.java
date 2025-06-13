package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.util.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String DATA_FILE = "D:\\data\\libro_data.txt";

    public void saveLibroInfo(String autor, String editorial, String genero, String titulo) throws IOException {
        // Validar datos de entrada
        if (autor == null || editorial == null || genero == null || titulo == null) {
            throw new IllegalArgumentException("Todos los campos son requeridos");
        }

        // Formatear la información del libro
        String libroData = String.format("%s,%s,%s,%s\n", autor, editorial, genero, titulo);

        // Verificar si ya existe contenido previo
        String existingContent = FileManager.readFromFile(DATA_FILE);
        String newContent = existingContent + libroData;

        // Guardar la información actualizada
        FileManager.saveToFile(newContent, DATA_FILE);
    }

    public List<String[]> getAllLibros() throws IOException {
        List<String[]> libros = new ArrayList<>();
        String content = FileManager.readFromFile(DATA_FILE);

        // Si el archivo está vacío, retornar lista vacía
        if (content.trim().isEmpty()) {
            return libros;
        }

        // Procesar cada línea del archivo
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String[] libroData = line.split(",");
                libros.add(libroData);
            }
        }

        return libros;
    }
}
