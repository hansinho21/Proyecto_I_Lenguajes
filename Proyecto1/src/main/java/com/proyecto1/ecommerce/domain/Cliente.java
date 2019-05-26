package com.proyecto1.ecommerce.domain;

public class Cliente {

	private int idCliente;
	private String correo;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private Rol rol;
	
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

	public String getPassword() {
		return contraseña;
	}

	public void setPassword(String password) {
		this.contraseña = password;
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
		return "Cliente [idCliente=" + idCliente + ", correo=" + correo + ", password=" + contraseña + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", rol=" + rol.getIdRol() + "]";
	}
	
}
