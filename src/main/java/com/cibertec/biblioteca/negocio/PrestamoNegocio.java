package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.entidades.Prestamo;
import com.cibertec.biblioteca.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoNegocio {
    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    public Prestamo grabar(Prestamo reserva){
        return prestamoRepositorio.save(reserva);
    }

    public List<Prestamo> obtener(){
        return(List<Prestamo>) prestamoRepositorio.findAll();
    }

    public Prestamo actualizar(Prestamo reserva){
        Prestamo c = prestamoRepositorio.findById(reserva.getId()).get();
        if(c!=null){
            return prestamoRepositorio.save(reserva);
        }else {return null;}
    }

    public Prestamo borrar(Long id){
        Prestamo c = prestamoRepositorio.findById(id).get();
        if(c!=null){
            prestamoRepositorio.delete(c);
        }else{return null;}
        return c;
    }
}
