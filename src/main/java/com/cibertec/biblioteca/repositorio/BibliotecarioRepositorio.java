package com.cibertec.biblioteca.repositorio;

import com.cibertec.biblioteca.entidades.Bibliotecario;
import org.springframework.data.repository.CrudRepository;

public interface BibliotecarioRepositorio extends CrudRepository<Bibliotecario, Long> {
}
