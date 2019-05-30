package com.proyecto1.ecommerce.domain;

public class DireccionEnvio {

	private int idDireccion;
	private String direccion;
	private String ciudad;
	private String Provincia;
	private int codigoPostal;
	private String telefono;
	private String telefono2;
	private Cliente cliente;
	
	public DireccionEnvio() {
		cliente = new Cliente();
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DireccionEnvio [idDireccion=" + idDireccion + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", Provincia=" + Provincia + ", codigoPostal=" + codigoPostal + ", telefono=" + telefono
				+ ", telefono2=" + telefono2 + ", cliente=" + cliente.getIdCliente() + "]";
	}

	
}
