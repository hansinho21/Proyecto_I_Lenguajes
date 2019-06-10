package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.domain.Marca;
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
	
	/*
	@Test
	public void insert() {
		Producto producto = new Producto();
		producto.setNombre("prueba3");
		producto.setDescripcion("prueba3.1");
		producto.setPrecio(1234);
		producto.setUnidadesExistentes(12);
		producto.setIva(true);
		producto.setDescuento(10);
		producto.getMarca().setIdMarca(4);
		producto.getCategoria().setIdCategoriaProducto(2);
		
		System.out.println(productoData.insert(producto));
		
	}
	*/
	/*
	@Test
	public void update() {
		Producto producto = new Producto();
		producto.setIdProducto(2);
		producto.setNombre("prueba2");
		producto.setDescripcion("prueba2.1");
		producto.setPrecio(1234);
		producto.setUnidadesExistentes(12);
		producto.setIva(true);
		producto.setDescuento(10);
		producto.getMarca().setIdMarca(4);
		producto.getCategoria().setIdCategoriaProducto(2);
		
		productoData.update(producto);
		
	}
	*/
	/*
	@Test
	public void delete() {
		productoData.delete(2);
	}
	*/
}
