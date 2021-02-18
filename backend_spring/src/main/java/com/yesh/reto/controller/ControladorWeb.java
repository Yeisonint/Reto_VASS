package com.yesh.reto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yesh.reto.model.Administrador;
import com.yesh.reto.model.Empleado;
import com.yesh.reto.model.Jefe;
import com.yesh.reto.repository.RepositorioAdministrador;
import com.yesh.reto.repository.RepositorioEmpleado;
import com.yesh.reto.repository.RepositorioJefe;

import org.springframework.ui.Model;

@Controller
public class ControladorWeb {
	
	@Autowired
	private RepositorioAdministrador repositorioAdministrador;
	@Autowired
	private RepositorioJefe repositorioJefe;
	@Autowired
	private RepositorioEmpleado repositorioEmpleado;
	
	private static Logger logger = LogManager.getLogger(ControladorWeb.class);
	
    // Página principal
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    
    @RequestMapping("/nuevojefe")
    public String nuevojefe(Model model) {
        Jefe jefe = new Jefe();
        model.addAttribute("jefe", jefe);
        return "nuevojefe.html";
    }
    @RequestMapping("/nuevoempleado")
    public String nuevoempleado(Model model) {
        Empleado empleado = new Empleado();
        long idjefe=0;
        model.addAttribute("empleado", empleado);
        return "nuevoempleado.html";
    }

    // Iniciar sesión
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }
    
    // Cerrar sesión
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login.html";
    }

    // Error al iniciar sesión
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
    
    // Mostrar todas las tablas de la base de datos
    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public String mostrarBaseDeDatos(Model model) 
    {
    	List<Administrador> administradores = null;
        List<Jefe> jefes = null;
        List<Empleado> empleados = null;
        // Pasamos la información desde la base de datos
    	try {
	        administradores =  repositorioAdministrador.findAll();
	        
    	} catch(Exception e){
    		logger.error("Error al obtener los administradores desde el repositorio");
    	}
    	try {
	        empleados =  repositorioEmpleado.findAll();
	        
    	} catch(Exception e){
    		logger.error("Error al obtener los empleados desde el repositorio");
    	}
    	try {
    		jefes =  repositorioJefe.findAll();
	        
    	} catch(Exception e){
    		logger.error("Error al obtener los jefes desde el repositorio");
    	}
    	
        model.addAttribute("administradores", administradores);
        model.addAttribute("jefes", jefes);
        model.addAttribute("empleados", empleados);

        return "tabla.html";
    }
}