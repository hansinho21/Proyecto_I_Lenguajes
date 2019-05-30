package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.DetalleOrdenData;

import com.proyecto1.ecommerce.domain.DetalleOrden;

@Service
public class DetalleOrdenBusiness {

	@Autowired
	private DetalleOrdenData detalleOrdenData;

	public List<DetalleOrden> findAll() {
		return detalleOrdenData.findAll();
	}

	public void insert(DetalleOrden detalleOrden) {
		detalleOrdenData.insert(detalleOrden);
	}

	public void updateCantidad(DetalleOrden detalleOrden) {
		detalleOrdenData.updateCantidad(detalleOrden);
	}

	public void deleteByIdOrden(DetalleOrden detalleOrden) {
		detalleOrdenData.deleteByIdOrden(detalleOrden);
	}

	public void deleteByIdProducto(DetalleOrden detalleOrden) {
		detalleOrdenData.deleteByIdProducto(detalleOrden);
	}
}
