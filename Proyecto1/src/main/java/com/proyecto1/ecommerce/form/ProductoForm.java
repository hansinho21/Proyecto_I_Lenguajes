package com.proyecto1.ecommerce.form;

import javax.validation.constraints.NotNull;

import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Marca;

public class ProductoForm {

	@NotNull
	private int idProducto;
	@NotNull
	private String nombreProducto;
	@NotNull
	private String descripcion;
	@NotNull
	private float precio;
	@NotNull
	private int unidadesExistentes;	
	@NotNull
	private boolean iva;
	@NotNull
	private int descuento;
	@NotNull
	private int idMarca;
	@NotNull
	private int idCategoria;
	public ProductoForm() {
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getUnidadesExistentes() {
		return unidadesExistentes;
	}
	public void setUnidadesExistentes(int unidadesExistentes) {
		this.unidadesExistentes = unidadesExistentes;
	}
	public boolean isIva() {
		return iva;
	}
	public void setIva(boolean iva) {
		this.iva = iva;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
	
}
