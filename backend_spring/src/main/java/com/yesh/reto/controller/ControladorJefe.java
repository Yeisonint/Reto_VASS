package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.reto.model.Jefe;
import com.yesh.reto.repository.RepositorioJefe;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ControladorJefe {
	@Autowired
	public RepositorioJefe repositorioJefe;

	// Obtener todos los jefes
	@RequestMapping(value = "/jefes", method = RequestMethod.GET, produces = "application/json")
	public List<Jefe> getAllJefes() {
		return repositorioJefe.findAll();
	}
	
}
