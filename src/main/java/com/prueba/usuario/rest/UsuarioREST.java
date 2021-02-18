package com.prueba.usuario.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.usuario.model.Usuario;
import com.prueba.usuario.service.UsuarioService;

@RestController
@RequestMapping ("usuario")
public class UsuarioREST {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsuarios(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		try {
			Usuario usuarioSave = usuarioService.save(usuario);
			return ResponseEntity.ok(usuarioSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	private ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		try {
			Usuario usuarioSave = usuarioService.save(usuario);
			return ResponseEntity.ok(usuarioSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "/delete/{id}")
	private ResponseEntity<?> deleteUsuario (@PathVariable("id") Integer id){
		usuarioService.deleteById(id);
		return ResponseEntity.ok(!(usuarioService.findById(id) != null));	
	}
}
