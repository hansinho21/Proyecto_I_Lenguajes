package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.Empleado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpleadoDataTest {

	@Autowired
	private EmpleadoData empleadoData;

/*	
	@Test
	public void findAll() {
		List<Empleado> empleados = new ArrayList<>();
		empleados = empleadoData.findAll();
		assertNotNull(empleados);
		for(int i=0;i<empleados.size();i++) {
			System.out.println(empleados.get(i).toString());
		}
	}
	*/

	@Test
	public void findByEmail() {
		Empleado empleado = empleadoData.findByEmail("admin@gmail.com");
		assertNotNull(empleado);
		//System.out.println(empleadoData.findByEmail("admin@gmail.com").toString());
	}
	
}
