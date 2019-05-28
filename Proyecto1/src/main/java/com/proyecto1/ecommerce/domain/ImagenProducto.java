package com.proyecto1.ecommerce.domain;

public class ImagenProducto {

	private int id;
	private String imagen;
	private Producto producto;
	
	public ImagenProducto() {
		producto = new Producto();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ImagenProducto [id=" + id + ", imagen=" + imagen + ", producto=" + producto.getIdProducto() + "]";
	}
	
}
