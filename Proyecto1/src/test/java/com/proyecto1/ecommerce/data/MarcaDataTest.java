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
import com.proyecto1.ecommerce.domain.Marca;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MarcaDataTest {

	@Autowired
	private MarcaData marcaData;

/*
	@Test
	public void findAll() {
		List<Marca> marcas = new ArrayList<>();
		marcas = marcaData.findAll();
		assertNotNull(marcas);
		for(int i=0;i<marcas.size();i++) {
			System.out.println(marcas.get(i).toString());
		}
	}
*/
	
	@Test
	public void insert() {		
		System.out.println(marcaData.insert("prueba66"));
	}

/*
	@Test
	public void update() {
		Marca marca = new Marca();
		marca.setIdMarca(5);
		marca.setNombreMarca("prueba3.1");
		
		marcaData.update(marca);
	}
*/
	/*
	@Test
	public void delete() {
		marcaData.delete(5);
	}
	*/
}
