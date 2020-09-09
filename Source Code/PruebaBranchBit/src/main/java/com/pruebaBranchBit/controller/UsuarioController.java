package com.pruebaBranchBit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaBranchBit.dao.UsuarioDao;
import com.pruebaBranchBit.model.Usuario;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@PostMapping("/usuarios")
	public Usuario registerUser(@Validated @RequestBody Usuario usuario) {
		return usuarioDao.save(usuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listUser() {
		return usuarioDao.findAll();
	}
	
	//@PutMapping("/usuario/{iduser}")
	// public
	
	@DeleteMapping("/usuarios/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		usuarioDao.deleteById(id);
	}
	
	@GetMapping("/auth/{usuario}/{password}")
	public List<Usuario> auth(@PathVariable(value="usuario") String usuario, @PathVariable(value="password") String password){
		return usuarioDao.auth(usuario, password);
	}

}



