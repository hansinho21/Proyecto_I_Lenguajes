package com.proyecto1.ecommerce.domain;

import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Empleado {

	private int idEmpleado;
	private String nombreEmpleado;
	private String apellidosEmpleado;
	private String departamento;
	private String telefonoOficina;
	private String correoEmpleado;
	private String contrasenaEmpleado;
	private Rol rol;
	
	public Empleado() {
		rol= new Rol();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidosEmpleado() {
		return apellidosEmpleado;
	}

	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
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

	public String getCorreoEmpleado() {
		return correoEmpleado;
	}

	public void setCorreoEmpleado(String correoEmpleado) {
		this.correoEmpleado = correoEmpleado;
	}

	public String getContrasenaEmpleado() {
		return contrasenaEmpleado;
	}

	public void setContrasenaEmpleado(String contrasenaEmpleado) {
		this.contrasenaEmpleado = contrasenaEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", apellidosEmpleado="
				+ apellidosEmpleado + ", departamento=" + departamento + ", telefonoOficina=" + telefonoOficina
				+ ", correoEmpleado=" + correoEmpleado + ", contrasenaEmpleado=" + contrasenaEmpleado + ", rol=" + rol
				+ "]";
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
	
		
}
