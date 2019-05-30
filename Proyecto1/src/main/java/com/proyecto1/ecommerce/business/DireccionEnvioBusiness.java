package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.DireccionEnvioData;
import com.proyecto1.ecommerce.domain.DireccionEnvio;

@Service
public class DireccionEnvioBusiness {

	@Autowired
	private DireccionEnvioData direccionEnvioData;

	public List<DireccionEnvio> findAll() {
		return direccionEnvioData.findAll();
	}
	
	public int insert(DireccionEnvio direccionEnvio) {
		return direccionEnvioData.insert(direccionEnvio);
	}

	public void update(DireccionEnvio direccionEnvio) {
		direccionEnvioData.update(direccionEnvio);
	}

	public void delete(int id) {
		direccionEnvioData.delete(id);
	}
	
}
