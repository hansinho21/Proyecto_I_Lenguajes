package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.EmpleadoData;
import com.proyecto1.ecommerce.domain.Empleado;

@Service
public class EmpleadoBusiness {

	@Autowired
	private EmpleadoData empleadoData;
	
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return empleadoData.findAll();
	}
	
	@Transactional(readOnly = true)
	public Empleado findByEmail(String correo) {
		return empleadoData.findByEmail(correo);
	}
	
	@Transactional(readOnly = true)
	public int insert(Empleado empleado) {
		return empleadoData.insert(empleado);
	}
	
	@Transactional(readOnly = true)
	public void update(Empleado empleado) {
		empleadoData.update(empleado);
	}
	
	@Transactional(readOnly = true)
	public void delete(int id) {
		empleadoData.delete(id);
	}
	
}
