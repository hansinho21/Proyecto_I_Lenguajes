package com.proyecto1.ecommerce.domain;

public class Producto {

	private int idProducto;
	private String nombre;
	private String descripcion;
	private int unidadesExistentes;
	private float precio;
	private boolean iva;
	private String imagen;
	private Marca marca;
	private CategoriaProducto categoria;
	
	public Producto() {
		marca = new Marca();
		categoria= new CategoriaProducto();
	}
	
	public CategoriaProducto getCategoria() {
		return categoria;
	}



	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", unidadesExistentes=" + unidadesExistentes + ", precio=" + precio + ", iva=" + iva + ", imagen="
				+ imagen + ", marca=" + marca + ", categoria=" + categoria + "]";
	} 
	
	
	
	
	
}
