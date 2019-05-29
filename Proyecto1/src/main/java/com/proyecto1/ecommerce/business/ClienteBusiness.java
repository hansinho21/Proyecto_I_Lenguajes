package com.proyecto1.ecommerce.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.ecommerce.data.ClienteData;
import com.proyecto1.ecommerce.domain.Cliente;

@Service
public class ClienteBusiness {

	@Autowired
	private ClienteData clienteData;
	
	public void insert(Cliente cliente) {
		clienteData.insert(cliente);
	}
	
	public List<Cliente> findAll(){
		return clienteData.findAll();
	}
	
	public Cliente findByEmail(String correo) {
		return clienteData.findByEmail(correo);
	}
	public void update(Cliente cliente) {
		clienteData.update(cliente);
	}
	public void delete(int id) {
		clienteData.delete(id);
	}
	

	
}
