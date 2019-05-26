package com.proyecto1.ecommerce.domain;

public class DetalleOrden {

	private int cantidad;
	private int precoUnitario;

	public DetalleOrden() {
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(int precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	
}
