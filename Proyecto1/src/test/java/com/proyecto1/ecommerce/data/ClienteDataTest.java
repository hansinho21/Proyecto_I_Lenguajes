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
		cliente.setContrasenaCliente("cliente6");
		cliente.getRol().setIdRol(14);
		cliente.setCorreo("cliente6@gmail.com");
		cliente.setNombre("Cliente6");
		cliente.setApellidos("Cliente6.5");
		
		
		System.out.println(clienteData.insert(cliente));
	}
*/
/*
	@Test
	public void update() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(15);
		cliente.setCorreo("quince@gmail.com");
		cliente.setContrasenaCliente("quince");
		cliente.setNombre("quince");
		cliente.setApellidos("quinceavos");
		cliente.getRol().setIdRol(14);
		
		clienteData.update(cliente);
	}
*/
	
	@Test
	public void delete() {
		clienteData.delete(18);
	}
	
}
