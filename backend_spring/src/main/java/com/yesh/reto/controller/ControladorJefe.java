package com.yesh.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

	// Implementación del CRUD para Jefes
	// Obtener un solo elemento
    @GetMapping("/jefes/{id}")
    public Jefe obtenerjefe(@PathVariable("id") long id) {
        return repositorioJefe.findById(id).get();
    }
    
    // Eliminar un elemento por su id
    @GetMapping("/jefes/eliminar/{id}")
    public String eliminarjefe(@PathVariable("id") long id) {
    	repositorioJefe.deleteById(id);
    	return "<a href=\"/\">Regresar</a>";
    }
    
    // Almacenar un nuevo elemento
    @PostMapping("/jefes/agregar")
    public String guardarjefe(@ModelAttribute("Jefe") Jefe jefe) {
    	try {
    		jefe.setRol("Jefe");
    		repositorioJefe.save(jefe);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    	return "<a href=\"/\">Regresar</a>";
    }
    
    // Editar un elemento
    @RequestMapping("jefes/editar/{id}")
    public ModelAndView editarjefe(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editarjefe.html");
        Jefe jefe = repositorioJefe.findById(id).get();
        mav.addObject("jefe", jefe);
         
        return mav;
    }
}
