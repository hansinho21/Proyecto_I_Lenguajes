package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

public class RolForm {

	@NotNull
	private int idRol;
	@NotNull
	private String tipo;
	public RolForm() {
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	
	

}

