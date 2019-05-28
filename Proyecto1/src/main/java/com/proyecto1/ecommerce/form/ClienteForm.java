package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

import com.proyecto1.ecommerce.domain.Rol;

public class ClienteForm {

	@NotNull
	private String nombreCliente;
	@NotNull
	private String apellidosCliente;
	@NotNull
	private String correoCliente;
	@NotNull
	private String contraseñaCliente;
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
		return nombreCliente;
	}
	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}
	public String getApellidos() {
		return apellidosCliente;
	}
	public void setApellidos(String apellidos) {
		this.apellidosCliente = apellidos;
	}
	public String getCorreo() {
		return correoCliente;
	}
	public void setCorreo(String correo) {
		this.correoCliente = correo;
	}

	public String getContraseña() {
		return contraseñaCliente;
	}

	public void setContraseña(String contraseña) {
		this.contraseñaCliente = contraseña;
	}
	

	
	
}
