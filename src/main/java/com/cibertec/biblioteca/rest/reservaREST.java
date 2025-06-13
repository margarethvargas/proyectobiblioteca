package com.cibertec.biblioteca.rest;

import com.cibertec.biblioteca.entidades.Reserva;
import com.cibertec.biblioteca.negocio.ReservaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class reservaREST {
    @Autowired
    private ReservaNegocio reservaNegocio;

    @PostMapping("")
    public Reserva grabar(@RequestBody Reserva reserva) {
        return reservaNegocio.grabar(reserva);
    }

    @GetMapping("")
    public List<Reserva> obtener() {
        try {
            return reservaNegocio.obtener();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @GetMapping("/lector/{idLector}")
    public List<Reserva> obtenerPorIdLector(@PathVariable(value = "idLector") Long idLector) {
        try {
            return reservaNegocio.obtenerPorIdLector(idLector);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("")
    public Reserva actualizar(@RequestBody Reserva reserva) {
        try{
            return reservaNegocio.actualizar(reserva);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar los datos");
        }
    }

    @DeleteMapping("/{id}")
    public Reserva borrar(@PathVariable(value = "id") Long id) {
        return reservaNegocio.borrar(id);
    }
}