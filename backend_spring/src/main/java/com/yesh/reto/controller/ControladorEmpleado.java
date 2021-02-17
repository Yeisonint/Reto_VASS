package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.reto.model.Empleado;
import com.yesh.reto.repository.RepositorioEmpleado;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ControladorEmpleado {
	@Autowired
	public RepositorioEmpleado repositorioEmpleado;

	// Obtener todos los empleados
	@RequestMapping(value = "/empleados", method = RequestMethod.GET, produces = "application/json")
	public List<Empleado> getAllEmpleados() {
		return repositorioEmpleado.findAll();
	}
	
}
