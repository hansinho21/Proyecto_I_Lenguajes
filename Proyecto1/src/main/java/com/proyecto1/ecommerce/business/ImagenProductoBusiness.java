package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.ImagenProductoData;
import com.proyecto1.ecommerce.domain.ImagenProducto;

@Service
public class ImagenProductoBusiness {

	@Autowired
	private ImagenProductoData imagenProductoData;

	public List<ImagenProducto> findAll() {
		return imagenProductoData.findAll();
	}
	
	public int insert(ImagenProducto imagenProducto) {
		return imagenProductoData.insert(imagenProducto);
	}
	
	public void update(ImagenProducto imagenProducto) {
		imagenProductoData.update(imagenProducto);
	}
	
	public void delete(int id) {
		imagenProductoData.delete(id);
	}
	
}
