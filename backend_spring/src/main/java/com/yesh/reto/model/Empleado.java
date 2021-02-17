package com.yesh.reto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Empleados")
public class Empleado extends Usuario {
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idJefe")
	@JsonBackReference
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
