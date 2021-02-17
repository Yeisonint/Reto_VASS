package com.yesh.reto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public RepositorioAdministrador repositorioAdministrador;
	public RepositorioJefe repositorioJefe;
	public RepositorioEmpleado repositorioEmpleado;
	
    // Página principal
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Has ingresado!";
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
    		System.out.println("Error Adm:"+e.getMessage());
    	}
    	try {
	        empleados =  repositorioEmpleado.findAll();
	        
    	} catch(Exception e){
    		System.out.println("Error Emp:"+e.getMessage());
    	}
    	try {
	        jefes =  repositorioJefe.findAll();
	        
    	} catch(Exception e){
    		System.out.println("Error: Jef"+e.getMessage());
    	}

        model.addAttribute("administradores", administradores);
        model.addAttribute("jefes", jefes);
        model.addAttribute("empleados", empleados);

        return "tabla.html";
    }
}