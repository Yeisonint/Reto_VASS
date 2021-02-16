package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.reto.model.Jefe;
import com.yesh.reto.repository.RepositorioJefe;

@RestController
@RequestMapping("/api/v1/")
public class ControladorJefe {
	@Autowired
	public RepositorioJefe repositorioJefe;

	// Obtener todos los jefes
	@GetMapping("/jefes")
	public List<Jefe> getAllJefes() {
		return repositorioJefe.findAll();
	}
	
}
