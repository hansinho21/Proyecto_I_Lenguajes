package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.EstadoOrdenData;
import com.proyecto1.ecommerce.domain.EstadoOrden;

@Service
public class EstadoOrdenBusiness {

	@Autowired
	private EstadoOrdenData estadoOrdenData;
	
	public List<EstadoOrden> findAll() {
		return estadoOrdenData.findAll();
	}
	
	public int insert(String nombre) {
		return estadoOrdenData.insert(nombre);
	}
	
	public void update(EstadoOrden estadoOrden) {
		estadoOrdenData.update(estadoOrden);
	}
	
	public void delete(int id) {
		estadoOrdenData.delete(id);
	}
	
}
