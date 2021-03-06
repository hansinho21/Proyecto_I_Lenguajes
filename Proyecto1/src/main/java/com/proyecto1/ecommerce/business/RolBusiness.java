package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.RolData;
import com.proyecto1.ecommerce.domain.Rol;

@Service
public class RolBusiness {

	@Autowired
	private RolData rolData;
	
	public List<Rol> findAll(){
		return rolData.findAll();
	}
	
	public int insert(String tipo) {
		return rolData.insert(tipo);
	}
	
	
	public void update(int id, String tipo) {
		rolData.update(id, tipo);
	}
	
	
	public void delete(int id) {
		rolData.delete(id);
	}
	
}
