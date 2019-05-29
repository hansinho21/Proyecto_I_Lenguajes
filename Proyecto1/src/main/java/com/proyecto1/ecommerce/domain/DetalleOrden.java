package com.proyecto1.ecommerce.domain;

public class DetalleOrden {

	private Orden orden;
	private Producto producto;
	private int cantidad;
	private float precoUnitario;

	public DetalleOrden() {
		orden = new Orden();
		producto = new Producto();
	}
	
	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	@Override
	public String toString() {
		return "DetalleOrden [orden=" + orden.getIdOrden() + ", producto=" + producto.getIdProducto() + 
				", cantidad=" + cantidad + ", precoUnitario="
				+ precoUnitario + "]";
	}

	
}
