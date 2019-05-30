package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.ProductoData;
import com.proyecto1.ecommerce.domain.Producto;

@Service
public class ProductoBusiness {

	@Autowired
	private ProductoData productoData;

	public List<Producto> findAll() {
		return productoData.findAll();
	}
	
	public int insert(Producto producto) {
		return productoData.insert(producto);
	}
	
	public void update(Producto producto) {
		productoData.update(producto);
	}
	
	public void delete(int id) {
		productoData.delete(id);
	}
	
}
