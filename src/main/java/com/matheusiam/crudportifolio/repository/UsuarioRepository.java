package com.matheusiam.crudportifolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusiam.crudportifolio.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
