package com.proyecto1.ecommerce.domain;

public class ItemCarrito {

	private Producto producto;
	private Cliente cliente;
	private int cantidad;
	
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

	@Override
	public String toString() {
		return "ItemCarrito [producto=" + producto.getIdProducto() + ", cliente=" + cliente.getIdCliente() + ", cantidad=" + cantidad + "]";
	}
	
}
