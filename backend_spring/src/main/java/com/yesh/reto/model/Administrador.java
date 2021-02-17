package com.yesh.reto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Administradores")
@Table(name="Administradores")
public class Administrador extends Usuario {
	
	public Administrador() {
		super();
	}

	public Administrador(String usuario, String clave, long salario, float porcentaje, boolean activo) {
		super(usuario, clave, salario, porcentaje, "Administrador", activo);
	}
}
