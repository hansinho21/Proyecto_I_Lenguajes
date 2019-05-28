package com.proyecto1.ecommerce.domain;

public class EstadoOrden {

	private int idEstadoOrden;
	private String estadoOrden;
	public EstadoOrden() {
	}
	public int getIdEstadoOrden() {
		return idEstadoOrden;
	}
	public void setIdEstadoOrden(int idEstadoOrden) {
		this.idEstadoOrden = idEstadoOrden;
	}
	public String getEstadoOrden() {
		return estadoOrden;
	}
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	@Override
	public String toString() {
		return "EstadoOrden [idEstadoOrden=" + idEstadoOrden + ", estadoOrden=" + estadoOrden + "]";
	}

	
	
}
