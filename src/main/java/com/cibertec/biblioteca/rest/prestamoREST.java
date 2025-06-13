package com.cibertec.biblioteca.rest;

import com.cibertec.biblioteca.entidades.Prestamo;
import com.cibertec.biblioteca.negocio.PrestamoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class prestamoREST {
    @Autowired
    private PrestamoNegocio prestamoNegocio;

    @PostMapping("")
    public Prestamo grabar(@RequestBody Prestamo prestamo) {
        return prestamoNegocio.grabar(prestamo);
    }

    @GetMapping("")
    public List<Prestamo> obtener() {
        try {
            return prestamoNegocio.obtener();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("")
    public Prestamo actualizar(@RequestBody Prestamo reserva) {
        try{
            return prestamoNegocio.actualizar(reserva);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar los datos");
        }
    }

    @DeleteMapping("/{id}")
    public Prestamo borrar(@PathVariable(value = "id") Long id) {
        return prestamoNegocio.borrar(id);
    }
}