package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.Cliente;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteDataTest {

	@Autowired
	private ClienteData clienteData;

	/*
	@Test
	public void findAll() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteData.findAll();
		assertNotNull(clientes);
		for(int i=0;i<clientes.size();i++) {
			System.out.println(clientes.get(i).toString());
		}
	}
	*/
/*
	@Test
	public void findByEmail() {
		System.out.println(clienteData.findByEmail("user@gmail.com").toString());
	}
	*/
	/*
	@Test
	public void insert() {
		Cliente cliente = new Cliente();
		cliente.setCorreo("cliente1@gmail.com");
		cliente.setPassword("cliente1");
		cliente.setNombre("Cliente1");
		cliente.setApellidos("Cliente1.1");
		cliente.getRol().setIdRol(14);
		
		clienteData.insert(cliente);
	}
*/
/*
	@Test
	public void update() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(4);
		cliente.setCorreo("cliente2@gmail.com");
		cliente.setPassword("cliente2");
		cliente.setNombre("Cliente2");
		cliente.setApellidos("Cliente2.1");
		cliente.getRol().setIdRol(14);
		
		clienteData.update(cliente);
	}
*/
	
	@Test
	public void delete() {
		clienteData.delete(4);
	}
	
}
