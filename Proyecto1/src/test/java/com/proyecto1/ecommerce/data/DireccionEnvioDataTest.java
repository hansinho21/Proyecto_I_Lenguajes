package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.DireccionEnvio;
import com.proyecto1.ecommerce.domain.Empleado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DireccionEnvioDataTest {

	@Autowired
	private DireccionEnvioData direccionEnvioData;

/*
	@Test
	public void findAll() {
		List<DireccionEnvio> direcciones = new ArrayList<>();
		direcciones = direccionEnvioData.findAll();
		assertNotNull(direcciones);
		for(int i=0;i<direcciones.size();i++) {
			System.out.println(direcciones.get(i).toString());
		}
	}
	*/
	/*
	@Test
	public void insert() {
		DireccionEnvio direccionEnvio = new DireccionEnvio();
		direccionEnvio.setDireccion("Prueba 2");
		direccionEnvio.setCiudad("Prueba 2.1");
		direccionEnvio.setProvincia("Prueba 2.2");
		direccionEnvio.setCodigoPostal(30555);
		direccionEnvio.setTelefono("Prueba 2.3");
		direccionEnvio.setTelefono2("Prueba 2.4");
		direccionEnvio.getCliente().setIdCliente(3);
		
		System.out.println(direccionEnvioData.insert(direccionEnvio));
	}
	*/
	/*
	@Test
	public void update() {
		DireccionEnvio direccionEnvio = new DireccionEnvio();
		direccionEnvio.setIdDireccion(2);
		direccionEnvio.setDireccion("Prueba 3");
		direccionEnvio.setCiudad("Prueba 3.1");
		direccionEnvio.setProvincia("Prueba 3.2");
		direccionEnvio.setCodigoPostal(30555);
		direccionEnvio.setTelefono("Prueba 3.3");
		direccionEnvio.setTelefono2("Prueba 3.4");
		direccionEnvio.getCliente().setIdCliente(3);
		
		direccionEnvioData.update(direccionEnvio);
	}
	*/
	
	@Test
	public void delete() {
		direccionEnvioData.delete(2);
	}
	
}
