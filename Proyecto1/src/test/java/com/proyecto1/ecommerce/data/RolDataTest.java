package com.proyecto1.ecommerce.data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto1.ecommerce.domain.Rol;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolDataTest {
	
	@Autowired
	private RolData rolData;

	@Test
	public void findAll() {
		List<Rol> roles = new ArrayList<>();
		roles = rolData.findAll();
		assertNotNull(roles);
		for(int i=0;i<roles.size();i++) {
			Rol rol = roles.get(i);
			System.out.println(rol.getIdRol() + "  " + rol.getTipo());
		}
	}
	
	/*
	@Test
	public void insert() {
		Rol rol = new Rol();
		rol = rolData.insert("prueba2");
		System.out.println(rol.getIdRol() + "  " + rol.getTipo());
	}
	*/
	
	/*
	@Test
	public void delete() {
		rolData.delete(11);
		findAll();
	}
	*/

}
