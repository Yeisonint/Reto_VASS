package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.reto.model.Administrador;
import com.yesh.reto.repository.RepositorioAdministrador;

@CrossOrigin(origins = "http://localhost:4200")
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
	
    @GetMapping("/administradores/{id}")
    private Administrador getPerson(@PathVariable("id") long id) {
        return repositorioAdministrador.findById(id).get();
    }

    @DeleteMapping("/administradores/{id}")
    private void deleteAdministrador(@PathVariable("id") long id) {
    	repositorioAdministrador.deleteById(id);
    }

    @PostMapping("/administradores")
    private long guardarAdministrador(@RequestBody Administrador admin) {
    	guardarOActualizar(admin);
        return admin.getId();
    }
    
    public void guardarOActualizar(Administrador admin) {
    	repositorioAdministrador.save(admin);
    }

    public void eliminarAdministrador(long id) {
    	repositorioAdministrador.deleteById(id);
    }
}
