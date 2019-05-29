package com.proyecto1.ecommerce.domain;

import java.util.Date;

public class Orden {

	private int idOrden;
	private Date fechaOrden;
	private Date fechaEnvio;
	private float valorEnvio;
	private float valorProductos;
	private float valorTotal;
	private Cliente cliente;
	private EstadoOrden estadoOrden;
	
	public Orden() {
		cliente = new Cliente();
		estadoOrden = new EstadoOrden();
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public float getValorEnvio() {
		return valorEnvio;
	}

	public void setValorEnvio(float valorEnvio) {
		this.valorEnvio = valorEnvio;
	}

	public float getValorProductos() {
		return valorProductos;
	}

	public void setValorProductos(float valorProductos) {
		this.valorProductos = valorProductos;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoOrden getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(EstadoOrden estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", fechaOrden=" + fechaOrden + ", fechaEnvio=" + fechaEnvio
				+ ", valorEnvio=" + valorEnvio + ", valorProductos=" + valorProductos + ", valorTotal=" + valorTotal
				+ ", cliente=" + cliente.getIdCliente() + ", estadoOrden=" + estadoOrden.getIdEstadoOrden() + "]";
	}

	
	
	
	
	
	
}
