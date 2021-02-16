package com.yesh.reto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Jefes")
public class Jefe extends Usuario {
	
	@OneToMany(mappedBy = "jefeAsignado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Empleado> empleados;
	
	public Jefe() {
		super();
	}

	public Jefe(String usuario, String clave, long salario, float porcentaje, boolean activo) {
		super(usuario, clave, salario, porcentaje, "Jefe", activo);
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
