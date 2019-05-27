package com.proyecto1.ecommerce.domain;

import java.util.LinkedList;
import java.util.List;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private String apellidos;
	private String departamento;
	private String telefonoOficina;
	private String correo;
	private String password;
	private Rol rol;
	
	public Empleado() {
		rol= new Rol();
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", departamento=" + departamento
				+ ", telefonoOficina=" + telefonoOficina + ", correo=" + correo + ", password=" + password + ", rol="
				+ rol.getIdRol() + "]";
	}
	
	
	
	
		
}
