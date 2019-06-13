package com.proyecto1.ecommerce.domain;

public class ItemCarrito {

	private Producto producto;
	private Cliente cliente;
	private int cantidad;
	private float precioUnitario;
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public ItemCarrito() {
		producto = new Producto();
		cliente = new Cliente();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	
}
