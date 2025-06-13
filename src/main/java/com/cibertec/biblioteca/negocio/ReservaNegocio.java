package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.entidades.Reserva;
import com.cibertec.biblioteca.repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaNegocio {
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public Reserva grabar(Reserva reserva){
        return reservaRepositorio.save(reserva);
    }

    public List<Reserva> obtener(){
        return(List<Reserva>) reservaRepositorio.findAll();
    }

    public Reserva actualizar(Reserva reserva){
        Reserva c = reservaRepositorio.findById(reserva.getId()).get();
        if(c!=null){
            return reservaRepositorio.save(reserva);
        }else {return null;}
    }

    public Reserva borrar(Long id){
        Reserva c = reservaRepositorio.findById(id).get();
        if(c!=null){
            reservaRepositorio.delete(c);
        }else{return null;}
        return c;
    }

    public List<Reserva> obtenerPorIdLector(Long idLector) {
        return reservaRepositorio.findByUsuarioId(idLector);
    }
}
