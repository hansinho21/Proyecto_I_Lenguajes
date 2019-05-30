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


	@Test
	public void findAll() {
		List<Empleado> empleados = new ArrayList<>();
		empleados = empleadoData.findAll();
		assertNotNull(empleados);
		for(int i=0;i<empleados.size();i++) {
			System.out.println(empleados.get(i).toString());
		}
	}
	
/*
	@Test
	public void findByEmail() {
		System.out.println(empleadoData.findByEmail("admin@gmail.com").toString());
	}
	*/
	/*
	@Test
	public void insert() {
		Empleado empleado = new Empleado();
		empleado.setCorreoEmpleado("empleado17@gmail.com");
		empleado.setContrasenaEmpleado("empleado4");
		empleado.setNombreEmpleado("Empleado4");
		empleado.setApellidosEmpleado("Empleado4.1");
		empleado.setDepartamento("Empleado4.2");
		empleado.setTelefonoOficina("Empleado4.3");
		empleado.getRol().setIdRol(12);
		
		System.out.println(empleadoData.insert(empleado));
	}
	*/
	/*
	@Test
	public void update() {
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(5);
		empleado.setCorreo("empleado2@gmail.com");
		empleado.setPassword("empleado2");
		empleado.setNombre("Empleado2");
		empleado.setApellidos("Empleado2.1");
		empleado.setDepartamento("Empleado2.2");
		empleado.setTelefonoOficina("Empleado2.3");
		empleado.getRol().setIdRol(15);
		
		empleadoData.update(empleado);
	}
	*/
	/*
	@Test
	public void delete() {
		empleadoData.delete(5);
	}
	*/
}
