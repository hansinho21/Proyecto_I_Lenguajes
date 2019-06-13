package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.CategoriaProductoData;
import com.proyecto1.ecommerce.domain.CategoriaProducto;

@Service
public class CategoriaProductoBusiness {

	@Autowired
	private CategoriaProductoData categoriaProductoData;
	
	public List<CategoriaProducto> findAll() {
		return categoriaProductoData.findAll();
	}
	
	public int insert(String nombre) {
		return categoriaProductoData.insert(nombre);
	}
	
	public void update(CategoriaProducto categoriaProducto) {
		categoriaProductoData.update(categoriaProducto);
	}

	public void delete(int id) {
		categoriaProductoData.delete(id);
	}
	
	public int findByname(String name) {
		  List<CategoriaProducto> categorias = categoriaProductoData.findAll();
		  int id=0;
		  for(int i=0;i<categorias.size();i++) {
		   if(categorias.get(i).getNombreCategoria().equals(name)) {
		    id=categorias.get(i).getIdCategoriaProducto();
		   }
		  }
		  return id;
		 }
}
