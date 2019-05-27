package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

import com.proyecto1.ecommerce.domain.Rol;

public class ClienteForm {

	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	private String correo;
	@NotNull
	private String password;
	@NotNull
	private int idRol;
	
	public ClienteForm() {
	}
	
	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
