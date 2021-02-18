package com.prueba.usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
}
 