package com.cibertec.biblioteca.util;

import java.io.*;

public class FileManager {
    public static void saveToFile(String data, String filePath) throws IOException {
        File file = new File(filePath);

        // Crear el directorio si no existe
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }

    public static String readFromFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            return "";
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
