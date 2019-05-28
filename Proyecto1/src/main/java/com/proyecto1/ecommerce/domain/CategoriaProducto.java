package com.proyecto1.ecommerce.domain;

public class CategoriaProducto {

	private int idCategoriaProducto;
	private String nombreCategoria;
	
	public CategoriaProducto() {
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

	@Override
	public String toString() {
		return "CategoriaProducto [idCategoriaProducto=" + idCategoriaProducto + ", nombreCategoria=" + nombreCategoria
				+ "]";
	}

	
	
}
