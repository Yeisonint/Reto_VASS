package com.yesh.reto.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleado extends Usuario {
	
	@ManyToOne()
	@JoinColumn(name = "idJefe")
	private Jefe jefeAsignado;

	public Empleado() {
		super();
	}

	public Empleado(String usuario, String clave, long salario, float porcentaje, boolean activo, Jefe jefe) {
		super(usuario, clave, salario, porcentaje, "Empleado", activo);
		setJefeAsignado(jefe);
	}

	public Jefe getJefeAsignado() {
		return jefeAsignado;
	}

	public void setJefeAsignado(Jefe jefeAsignado) {
		this.jefeAsignado = jefeAsignado;
	}

}
