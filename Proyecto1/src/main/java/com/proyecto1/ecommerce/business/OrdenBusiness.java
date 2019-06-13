package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.OrdenData;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Orden;

@Service
public class OrdenBusiness {

	@Autowired
	private OrdenData ordenData;
	
	public List<Orden> findAll() {
		return ordenData.findAll();
	}
	
	public HashMap<Cliente, Integer> ventasClientes() {
		return ordenData.ventasClientes();
	}
	
	public int insert(Orden orden) {
		return ordenData.insert(orden);
	}
	
	public void confirmarOrden(Orden orden) {
		ordenData.confirmarOrden(orden);
	}
	
	public void update(Orden orden) {
		ordenData.update(orden);
	}

	public void delete(int id) {
		ordenData.delete(id);
	}
	
}
