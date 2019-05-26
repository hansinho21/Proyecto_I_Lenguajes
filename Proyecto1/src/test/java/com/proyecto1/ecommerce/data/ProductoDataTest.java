package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoDataTest {
	
	@Autowired
	private ProductoData productoData;

	@Test
	public void findAll() {
		List<Producto> productos = new ArrayList<>();
		productos = productoData.findAll();
		assertNotNull(productos);
		for(int i=0;i<productos.size();i++) {
			System.out.println(productos.get(i).toString());
		}
	}
	
}
