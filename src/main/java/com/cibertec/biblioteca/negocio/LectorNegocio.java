package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.repositorio.LectorRepositorio;
import com.cibertec.biblioteca.entidades.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorNegocio {
    @Autowired
    private LectorRepositorio lectorRepositorio;

    public Lector grabar(Lector lector){
        return lectorRepositorio.save(lector);
    }

    public List<Lector> obtener(){
        return(List<Lector>) lectorRepositorio.findAll();
    }

    public Lector actualizar(Lector bibliotecario){
        Lector c = lectorRepositorio.findById(bibliotecario.getId()).get();
        if(c!=null){
            return lectorRepositorio.save(bibliotecario);
        }else {return null;}
    }

    public Lector borrar(Long id){
        Lector c = lectorRepositorio.findById(id).get();
        if(c!=null){
            lectorRepositorio.delete(c);
        }else{return null;}
        return c;
    }
}
