package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.MarcaData;
import com.proyecto1.ecommerce.domain.Marca;

@Service
public class MarcaBusiness {

	@Autowired
	private MarcaData marcaData;

	public List<Marca> findAll() {
		return marcaData.findAll();
	}
	
	public int insert(String nombre) {
		return marcaData.insert(nombre);
	}
	
	public void update(Marca marca) {
		marcaData.update(marca);
	}
	
	public void delete(int id) {
		marcaData.delete(id);
	}
	
}
