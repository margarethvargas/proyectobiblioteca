package com.cibertec.biblioteca.negocio;

import com.cibertec.biblioteca.entidades.Usuario;
import com.cibertec.biblioteca.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioNegocio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario grabar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario> obtener(){
        return(List<Usuario>) usuarioRepositorio.findAll();
    }

    public Usuario actualizar(Usuario usuario){
        Usuario c = usuarioRepositorio.findById(usuario.getId()).get();
        if(c!=null){
            return usuarioRepositorio.save(usuario);
        }else {return null;}
    }

    public Usuario borrar(Long id){
        Usuario c = usuarioRepositorio.findById(id).get();
        if(c!=null){
            usuarioRepositorio.delete(c);
        }else{return null;}
        return c;
    }

    private List<SimpleGrantedAuthority> getAuthority(Usuario usuario) {
        return Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole()));
    }

    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
}
