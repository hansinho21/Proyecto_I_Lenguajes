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
import com.proyecto1.ecommerce.domain.DetalleOrden;
import com.proyecto1.ecommerce.domain.ImagenProducto;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Marca;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DetalleOrdenDataTest {

	@Autowired
	private DetalleOrdenData detalleOrdenData;

/*
	@Test
	public void findAll() {
		List<DetalleOrden> items = new ArrayList<>();
		items = detalleOrdenData.findAll();
		assertNotNull(items);
		for(int i=0;i<items.size();i++) {
			System.out.println(items.get(i).toString());
		}
	}
*/
/*
	@Test
	public void insert() {	
		DetalleOrden detalleOrden = new DetalleOrden();
		detalleOrden.getOrden().setIdOrden(1);
		detalleOrden.getProducto().setIdProducto(4);
		detalleOrden.setCantidad(3);
		detalleOrden.setPrecoUnitario(123123);
		detalleOrdenData.insert(detalleOrden);
	}
*/
/*
	@Test
	public void update() {
		DetalleOrden detalleOrden = new DetalleOrden();
		detalleOrden.getOrden().setIdOrden(1);
		detalleOrden.getProducto().setIdProducto(4);
		detalleOrden.setCantidad(7);
		detalleOrden.setPrecoUnitario(22222);
		
		detalleOrdenData.updateCantidad(detalleOrden);
	}
*/
	/*
	@Test
	public void deleteByIdProducto() {
		DetalleOrden orden = new DetalleOrden();
		orden.getProducto().setIdProducto(4);
		detalleOrdenData.deleteByIdProducto(orden);
	}
	*/
	
	@Test
	public void deleteByIdOrden() {
		DetalleOrden orden = new DetalleOrden();
		orden.getOrden().setIdOrden(1);
		detalleOrdenData.deleteByIdOrden(orden);
	}
	
}
