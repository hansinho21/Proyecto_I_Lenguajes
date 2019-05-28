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
import com.proyecto1.ecommerce.domain.ImagenProducto;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Marca;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCarritoDataTest {

	@Autowired
	private ItemCarritoData itemCarritoData;

/*
	@Test
	public void findAll() {
		List<ItemCarrito> items = new ArrayList<>();
		items = itemCarritoData.findAll();
		assertNotNull(items);
		for(int i=0;i<items.size();i++) {
			System.out.println(items.get(i).toString());
		}
	}
*/

	@Test
	public void insert() {	
		ItemCarrito item = new ItemCarrito();
		item.getCliente().setIdCliente(3);
		item.getProducto().setIdProducto(6);
		item.setCantidad(3);
		itemCarritoData.insert(item);
	}

/*
	@Test
	public void updateByIdCliente() {
		ItemCarrito item = new ItemCarrito();
		item.getCliente().setIdCliente(3);
		item.getProducto().setIdProducto(1);
		item.setCantidad(11);
		
		itemCarritoData.updateCantidad(item);
	}
*/
	/*
	@Test
	public void deleteByIdProducto() {
		ItemCarrito item = new ItemCarrito();
		item.getProducto().setIdProducto(1);
		itemCarritoData.deleteByIdProducto(item);
	}
	*/
	/*
	@Test
	public void deleteByIdCliente() {
		ItemCarrito item = new ItemCarrito();
		item.getCliente().setIdCliente(3);
		itemCarritoData.deleteByIdProducto(item);
	}
	*/
}
