package com.yesh.reto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="usuario")
	private String usuario;
	@Column(name="clave")
	private String clave;
	@Column(name="salario")
	private long salario;
	@Column(name="porcentaje")
	private float porcentaje;
	@Column(name="rol")
	private String rol;
	@Column(name="activo")
	private boolean activo;
	
	public Usuario() {
		
	}

	public Usuario(String usuario, String clave, long salario, float porcentaje, String rol, boolean activo) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.salario = salario;
		this.porcentaje = porcentaje;
		this.rol = rol;
		this.activo = activo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
