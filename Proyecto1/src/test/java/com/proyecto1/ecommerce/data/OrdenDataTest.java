package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Orden;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdenDataTest {

	@Autowired
	private OrdenData ordenData;
	
	/*
	@Test
	public void findAll() {
		List<Orden> ordenes = new ArrayList<>();
		ordenes = ordenData.findAll();
		assertNotNull(ordenes);
		for(int i=0;i<ordenes.size();i++) {
			System.out.println(ordenes.get(i).toString());
		}
	}
*/
	
	/*
	@Test
	public void insert() {
		Orden orden = new Orden();
		orden.setFechaOrden(new Date(10));
		orden.setFechaEnvio(new Date(10));
		orden.setValorEnvio(1000);
		orden.setValorProductos(111111);
		orden.setValorTotal(123123132);
		orden.getCliente().setIdCliente(3);
		orden.getEstadoOrden().setIdEstadoOrden(4);
		
		System.out.println(ordenData.insert(orden));
	}
	*/
	/*
	@Test
	public void update() {
		Orden orden = new Orden();
		orden.setIdOrden(4);
		orden.setFechaOrden(new Date(50));
		orden.setFechaEnvio(new Date(50));
		orden.setValorEnvio(5555);
		orden.setValorProductos(7777);
		orden.setValorTotal(3333);
		orden.getCliente().setIdCliente(3);
		orden.getEstadoOrden().setIdEstadoOrden(4);
		
		ordenData.update(orden);
	}
	*/
	
	@Test
	public void delete() {
		ordenData.delete(4);
	}
	
}
