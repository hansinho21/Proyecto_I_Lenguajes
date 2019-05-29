package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

public class CategoriaForm {

	@NotNull
	private int idCategoriaProducto;
	@NotNull
	private String nombreCategoria;
	
	public CategoriaForm() {
	}
	public int getIdCategoriaProducto() {
		return idCategoriaProducto;
	}
	public void setIdCategoriaProducto(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	
	
	
}
