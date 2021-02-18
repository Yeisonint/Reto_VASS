package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yesh.reto.model.Administrador;
import com.yesh.reto.repository.RepositorioAdministrador;

@RestController
@RequestMapping("/api/v1/")
public class ControladorAdministrador {
	@Autowired
	public RepositorioAdministrador repositorioAdministrador;

	// Obtener todos los administradores
	@RequestMapping(value = "/administradores", method = RequestMethod.GET, produces = "application/json")
	public List<Administrador> getAllAdministradores() {
		return repositorioAdministrador.findAll();
	}
	
	// Implementación del CRUD para Administradores
	// Obtener un solo elemento
    @GetMapping("/administradores/{id}")
    private Administrador obtenerAdministrador(@PathVariable("id") long id) {
        return repositorioAdministrador.findById(id).get();
    }
    
    // Eliminar un elemento por su id
    @DeleteMapping("/administradores/{id}")
    private void eliminareAdministrador(@PathVariable("id") long id) {
    	repositorioAdministrador.deleteById(id);
    }
    
    // Almacenar un nuevo elemento
    @PostMapping("/administradores")
    private long guardarAdministrador(@RequestParam("usuario")String usuario,
    		@RequestParam("clave")String clave,
    		@RequestParam("salario")long salario,
    		@RequestParam("porcentaje")float porcentaje,
    		@RequestParam("activo")boolean activo) {
    	Administrador admin = new Administrador(usuario,clave,salario,porcentaje,activo);
    	try {
    		repositorioAdministrador.save(admin);
    		return admin.getId();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
    	
    }
    
    // Actualizar un elemento
    @PutMapping("/administradores")
    private long actualizarAdministrador(@RequestParam("id")long id,
    		@RequestParam("usuario")String usuario,
    		@RequestParam("clave")String clave,
    		@RequestParam("salario")long salario,
    		@RequestParam("porcentaje")float porcentaje,
    		@RequestParam("activo")boolean activo) {
    	Administrador admin = new Administrador(usuario,clave,salario,porcentaje,activo);
    	try {
    		repositorioAdministrador.save(admin);
    		return admin.getId();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
    	
    }
}
