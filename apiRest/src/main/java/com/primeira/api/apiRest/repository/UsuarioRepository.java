package com.primeira.api.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeira.api.apiRest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {	
}
