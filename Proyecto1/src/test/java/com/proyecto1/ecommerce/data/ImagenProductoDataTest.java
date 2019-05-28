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
import com.proyecto1.ecommerce.domain.Marca;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ImagenProductoDataTest {

	@Autowired
	private ImagenProductoData imagenProductoData;

/*
	@Test
	public void findAll() {
		List<ImagenProducto> imagenes = new ArrayList<>();
		imagenes = imagenProductoData.findAll();
		assertNotNull(imagenes);
		for(int i=0;i<imagenes.size();i++) {
			System.out.println(imagenes.get(i).toString());
		}
	}
*/
	/*
	@Test
	public void insert() {	
		ImagenProducto imagen = new ImagenProducto();
		imagen.setImagen("prueba1");
		imagen.getProducto().setIdProducto(1);
		imagenProductoData.insert(imagen);
	}
*/
/*
	@Test
	public void update() {
		ImagenProducto imagen = new ImagenProducto();
		imagen.setId(1);
		imagen.setImagen("prueba1.1");
		imagen.getProducto().setIdProducto(1);
		
		imagenProductoData.update(imagen);
	}
*/
	
	@Test
	public void delete() {
		imagenProductoData.delete(1);
	}
	
}
