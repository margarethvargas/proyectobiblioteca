package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.entidades.Bibliotecario;
import com.cibertec.biblioteca.repositorio.BibliotecarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioNegocio {
    @Autowired
    private BibliotecarioRepositorio bibliotecarioRepositorio;

    public Bibliotecario grabar(Bibliotecario bibliotecario){
        return bibliotecarioRepositorio.save(bibliotecario);
    }

    public List<Bibliotecario> obtener(){
        return(List<Bibliotecario>) bibliotecarioRepositorio.findAll();
    }

    public Bibliotecario actualizar(Bibliotecario bibliotecario){
        Bibliotecario c = bibliotecarioRepositorio.findById(bibliotecario.getId()).get();
        if(c!=null){
            return bibliotecarioRepositorio.save(bibliotecario);
        }else {return null;}
    }

    public Bibliotecario borrar(Long id){
        Bibliotecario c = bibliotecarioRepositorio.findById(id).get();
        if(c!=null){
            bibliotecarioRepositorio.delete(c);
        }else{return null;}
        return c;
    }
}
