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


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaProductoDataTest {

	@Autowired
	private CategoriaProductoData categoriaProductoData;

/*	
	@Test
	public void findAll() {
		List<CategoriaProducto> categorias = new ArrayList<>();
		categorias = categoriaProductoData.findAll();
		assertNotNull(categorias);
		for(int i=0;i<categorias.size();i++) {
			System.out.println(categorias.get(i).toString());
		}
	}
*/
/*
	@Test
	public void insert() {		
		System.out.println(categoriaProductoData.insert("categoria3"));
	}
/*
/*
	@Test
	public void update() {
		CategoriaProducto categoria = new CategoriaProducto();
		categoria.setIdCategoriaProducto(3);
		categoria.setNombreCategoria("prueba3.1");
		
		categoriaProductoData.update(categoria);
	}
*/
	
	@Test
	public void delete() {
		categoriaProductoData.delete(2);
	}
	
}
