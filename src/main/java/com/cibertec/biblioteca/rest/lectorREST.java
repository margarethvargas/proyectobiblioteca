package com.cibertec.biblioteca.rest;

import com.cibertec.biblioteca.entidades.Lector;
import com.cibertec.biblioteca.negocio.LectorNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/lector")
public class lectorREST {
    @Autowired
    private LectorNegocio lectorNegocio;

    @PostMapping("")
    public Lector grabar(@RequestBody Lector lector) {
        return lectorNegocio.grabar(lector);
    }

    @GetMapping("")
    public List<Lector> obtener() {
        try {
            return lectorNegocio.obtener();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }
    @PutMapping("")
    public Lector actualizar(@RequestBody Lector bibliotecario) {
        try{
            return lectorNegocio.actualizar(bibliotecario);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar los datos");
        }
    }

    @DeleteMapping("/{id}")
    public Lector borrar(@PathVariable(value = "id") Long id) {
        return lectorNegocio.borrar(id);
    }
}