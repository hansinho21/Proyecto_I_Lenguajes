package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

import com.proyecto1.ecommerce.domain.Rol;

public class EmpleadoForm {

	@NotNull
	private int idEmpleado;
	@NotNull
	private String nombreEmpleado;
	@NotNull
	private String apellidosEmpleado;
	@NotNull
	private String departamento;
	@NotNull
	private String telefonoOficina;
	@NotNull
	private String correoEmpleado;
	@NotNull
	private String contrasenaEmpleado;
	@NotNull
	private int idRol;
	
	public EmpleadoForm() {
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
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	
	
	
	
	
}

