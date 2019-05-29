package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

public class DireccionEnvioForm {

	@NotNull
	private int idDireccion;
	@NotNull
	private String direccion;
	@NotNull
	private String Provincia;
	@NotNull
	private int codigoPostal;
	@NotNull
	private String telefono;
	public DireccionEnvioForm() {
	}
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	



}


