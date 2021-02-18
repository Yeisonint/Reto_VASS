package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yesh.reto.model.Empleado;
import com.yesh.reto.repository.RepositorioEmpleado;
import com.yesh.reto.repository.RepositorioJefe;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ControladorEmpleado {
	@Autowired
	public RepositorioEmpleado repositorioEmpleado;
	@Autowired
	public RepositorioJefe repositorioJefe;

	// Obtener todos los empleados
	@RequestMapping(value = "/empleados", method = RequestMethod.GET, produces = "application/json")
	public List<Empleado> getAllEmpleados() {
		return repositorioEmpleado.findAll();
	}
	
	// Implementación del CRUD para Empleados
	// Obtener un solo elemento
    @GetMapping("/empleados/{id}")
    public Empleado obtenerempleado(@PathVariable("id") long id) {
        return repositorioEmpleado.findById(id).get();
    }
    
    // Eliminar un elemento por su id
    @GetMapping("/empleados/eliminar/{id}")
    public String eliminarempleado(@PathVariable("id") long id) {
    	repositorioEmpleado.deleteById(id);
    	return "<a href=\"/\">Regresar</a>";
    }
    
    // Almacenar un nuevo elemento
    @RequestMapping("/empleados/agregar")
    public String guardarempleado(@ModelAttribute("Empleado") Empleado empleado) {
    	System.out.println(repositorioJefe.findById(empleado.getIdJefe()).get().getUsuario());
    	try {
    		empleado.setRol("Empleado");
    		empleado.setJefeAsignado(repositorioJefe.findById(empleado.getIdJefe()).get());
    		repositorioEmpleado.save(empleado);
		} catch (Exception e) {
			System.err.println("Error agregando empleado: "+e.getMessage());
		}
    	return "<a href=\"/\">Regresar</a>";
    }
    
    // Editar un elemento
    @RequestMapping("/empleados/editar/{id}")
    public ModelAndView editarempleado(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editarempleado.html");
        Empleado empleado = repositorioEmpleado.findById(id).get();
        mav.addObject("empleado", empleado);
        return mav;
    }
	
}
