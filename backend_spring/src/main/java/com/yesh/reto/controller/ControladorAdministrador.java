package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.reto.model.Administrador;
import com.yesh.reto.repository.RepositorioAdministrador;

@RestController
@RequestMapping("/api/v1/")
public class ControladorAdministrador {
	@Autowired
	public RepositorioAdministrador repositorioAdministrador;

	// Obtener todos los administradores
	@GetMapping("/administradores")
	public List<Administrador> getAllAdministradores() {
		return repositorioAdministrador.findAll();
	}
	
}
