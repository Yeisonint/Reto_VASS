package com.yesh.reto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Jefes")
@Table(name="Jefes")
public class Jefe extends Usuario {
	
	public Jefe() {
		super();
	}

	public Jefe(String usuario, String clave, long salario, float porcentaje, boolean activo) {
		super(usuario, clave, salario, porcentaje, "Jefe", activo);
	}
	
}
