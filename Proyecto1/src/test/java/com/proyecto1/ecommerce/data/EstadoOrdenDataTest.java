package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.EstadoOrden;
import com.proyecto1.ecommerce.domain.Marca;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoOrdenDataTest {

	@Autowired
	private EstadoOrdenData estadoOrdenData;

/*
	@Test
	public void findAll() {
		List<EstadoOrden> estadoOrden = new ArrayList<>();
		estadoOrden = estadoOrdenData.findAll();
		assertNotNull(estadoOrden);
		for(int i=0;i<estadoOrden.size();i++) {
			System.out.println(estadoOrden.get(i).toString());
		}
	}
*/
	/*
	@Test
	public void insert() {		
		estadoOrdenData.insert("prueba1");
	}
*/
/*
	@Test
	public void update() {
		EstadoOrden estadoOrden = new EstadoOrden();
		estadoOrden.setIdEstadoOrden(3);
		estadoOrden.setEstadoOrden("prueba1.1");
		
		estadoOrdenData.update(estadoOrden);
	}
*/
	
	@Test
	public void delete() {
		estadoOrdenData.delete(3);
	}
	
}
