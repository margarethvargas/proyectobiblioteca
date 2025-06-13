package com.cibertec.biblioteca.rest;

import com.cibertec.biblioteca.negocio.DataManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileManagerREST {

    private final DataManager dataManager;

    public FileManagerREST() {
        this.dataManager = new DataManager();
    }

    @PostMapping("/libro")
    public ResponseEntity<String> saveLibro(
            @RequestParam String autor,
            @RequestParam String editorial,
            @RequestParam String genero,
            @RequestParam String titulo) {
        try {
                dataManager.saveLibroInfo(autor, editorial, genero, titulo);
            return ResponseEntity.ok("Libro guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al guardar libro: " + e.getMessage());
        }
    }

    @GetMapping("/libro")
    public ResponseEntity<?> getAllLibros() {
        try {
            List<String[]> libros = dataManager.getAllLibros();
            if (libros.isEmpty()) {
                return ResponseEntity.ok("No hay libros registrados");
            }
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al obtener libros: " + e.getMessage());
        }
    }
} 