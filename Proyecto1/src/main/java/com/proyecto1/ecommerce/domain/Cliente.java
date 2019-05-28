package com.proyecto1.ecommerce.domain;

public class Cliente {

	private int idCliente;
	private String correo;
	private String contrasenaCliente;
	private String nombre;
	private String apellidos;
	private Rol rol;
	
	public Cliente(int idCliente, String correo, String contrasena, String nombre, String apellidos, Rol rol) {
		this.idCliente = idCliente;
		this.correo = correo;
		this.contrasenaCliente = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rol = rol;
	}

	public Cliente(int idCliente, String correo, String contrasenaCliente, String nombre, String apellidos) {
		this.idCliente = idCliente;
		this.correo = correo;
		this.contrasenaCliente = contrasenaCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}



	public Cliente() {
		this.rol = new Rol();
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}



	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenaCliente() {
		return contrasenaCliente;
	}

	public void setContrasenaCliente(String contrasenaCliente) {
		this.contrasenaCliente = contrasenaCliente;
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", correo=" + correo + ", password=" + contrasenaCliente + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", rol=" + rol.getIdRol() + "]";
	}
	
}
