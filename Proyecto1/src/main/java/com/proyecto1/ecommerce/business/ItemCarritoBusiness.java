package com.proyecto1.ecommerce.business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.ItemCarritoData;
import com.proyecto1.ecommerce.domain.ItemCarrito;

@Service
public class ItemCarritoBusiness {

	@Autowired
	private ItemCarritoData itemCarritoData;

	public List<ItemCarrito> findAll() {
		return itemCarritoData.findAll();
	}
	
	public void insert(ItemCarrito itemCarrito) {
		itemCarritoData.insert(itemCarrito);
	}
	
	public void updateCantidad(ItemCarrito itemCarrito) {
		itemCarritoData.update(itemCarrito);
	}
	
	public void deleteByIdCliente(ItemCarrito itemCarrito) {
		itemCarritoData.deleteByIdCliente(itemCarrito);
	}
	
	public void deleteByIdProducto(ItemCarrito itemCarrito) {
		itemCarritoData.deleteByIdProducto(itemCarrito);
	}
	
	public void findByIdCliente(int id) {
		itemCarritoData.findByIdCliente(id);
	}
	
}
