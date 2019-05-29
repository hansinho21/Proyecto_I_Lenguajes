package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

public class MarcaForm {

	@NotNull
	private int idMarca;
	@NotNull
	private String nombreMarca;
	public MarcaForm() {
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	
	
}
