package com.pruebaBranchBit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pruebaBranchBit.model.Usuario;


public interface UsuarioDao  extends JpaRepository<Usuario, Integer>{
	
	
	@Query("Select p From Usuario p where p.usuario=:usuario and p.password=:password")
	public List<Usuario> auth(@Param("usuario") String usuario, @Param("password") String password);

}
