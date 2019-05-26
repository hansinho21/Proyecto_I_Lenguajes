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

	
	@Test
	public void findAll() {
		List<Cliente> clientes = new ArrayList<>();
		clientes = clienteData.findAll();
		assertNotNull(clientes);
		for(int i=0;i<clientes.size();i++) {
			System.out.println(clientes.get(i).toString());
		}
	}
/*
	@Test
	public void findByEmail() {
		System.out.println(clienteData.findByEmail("user@gmail.com").toString());
	}
	*/
}
