package com.yesh.reto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected long id;
	
	@Column(name="usuario")
	protected String usuario;
	@Column(name="clave")
	protected String clave;
	@Column(name="salario")
	protected long salario;
	@Column(name="porcentaje")
	protected float porcentaje;
	@Column(name="rol")
	protected String rol;
	@Column(name="activo")
	protected boolean activo;
	
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
