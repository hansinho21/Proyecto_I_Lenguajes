package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

import com.proyecto1.ecommerce.domain.Rol;

public class ClienteForm {
	
	@NotNull
	private int idCliente;
	@NotNull
	private String nombreCliente;
	@NotNull
	private String apellidosCliente;
	@NotNull
	private String correoCliente;
	@NotNull
	private String contrasenaCliente;
	@NotNull
	private int idRol;
	
	public ClienteForm() {
	}
	
	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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


	public String getContrasenaCliente() {
		return contrasenaCliente;
	}


	public void setContrasenaCliente(String contrasenaCliente) {
		this.contrasenaCliente = contrasenaCliente;
	}

	
	

	
	
}
