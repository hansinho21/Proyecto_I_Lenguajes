package com.proyecto1.ecommerce.domain;

public class Producto {

	private int idProducto;
	private String nombre;
	private String descripcion;
	private float precio;
	private int unidadesExistentes;	
	private boolean iva;
	private int descuento;
	private Marca marca;
	private CategoriaProducto categoria;
	private String urlImagen;
	
	public Producto() {
		marca = new Marca();
		categoria= new CategoriaProducto();
	}
	
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}



	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUnidadesExistentes() {
		return unidadesExistentes;
	}

	public void setUnidadesExistentes(int unidadesExistentes) {
		this.unidadesExistentes = unidadesExistentes;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isIva() {
		return iva;
	}

	public void setIva(boolean iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", unidadesExistentes=" + unidadesExistentes + ", iva=" + iva + ", descuento="
				+ descuento + ", marca=" + marca + ", categoria=" + categoria + ", urlImagen=" + urlImagen + "]";
	}


	
	
	
	
	
	
	
}
