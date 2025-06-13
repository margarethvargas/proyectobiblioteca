package com.cibertec.biblioteca.rest;

import com.cibertec.biblioteca.entidades.Bibliotecario;
import com.cibertec.biblioteca.negocio.BibliotecarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecario")
public class bibliotecarioREST {
    @Autowired
    private BibliotecarioNegocio bibliotecarioNegocio;

    @PostMapping("")
    public Bibliotecario grabar(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioNegocio.grabar(bibliotecario);
    }

    @GetMapping("")
    public List<Bibliotecario> obtener() {
        try {
            return bibliotecarioNegocio.obtener();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }
    @PutMapping("")
    public Bibliotecario actualizar(@RequestBody Bibliotecario bibliotecario) {
        try{
            return bibliotecarioNegocio.actualizar(bibliotecario);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar los datos");
        }
    }

    @DeleteMapping("/{id}")
    public Bibliotecario borrar(@PathVariable(value = "id") Long id) {
        return bibliotecarioNegocio.borrar(id);
    }
}