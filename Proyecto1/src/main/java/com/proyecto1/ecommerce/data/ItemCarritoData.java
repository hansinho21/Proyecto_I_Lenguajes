package com.proyecto1.ecommerce.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.ImagenProducto;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Marca;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class ItemCarritoData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<ItemCarrito> findAll() {
		String sqlSelect = "CALL `Item_Carrito_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new ItemCarritoWithIdClienteExtractor());
	}
	
	@Transactional(readOnly = true)
	public void insert(ItemCarrito itemCarrito) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Item_Carrito_Insert`(?,?,?,?);");
			cs.setInt(1, itemCarrito.getCliente().getIdCliente());
			cs.setInt(2, itemCarrito.getProducto().getIdProducto());
			cs.setInt(3, itemCarrito.getCantidad());
			
			cs.executeUpdate();
			
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	@Transactional(readOnly = true)
	public void updateCantidad(ItemCarrito itemCarrito) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Item_Carrito_UpdateCantidad`(?,?,?);");
			cs.setInt(1, itemCarrito.getCliente().getIdCliente());
			cs.setInt(2, itemCarrito.getProducto().getIdProducto());
			cs.setInt(3, itemCarrito.getCantidad());
			
			cs.executeUpdate();
			
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	@Transactional(readOnly = true)
	public void deleteByIdCliente(ItemCarrito itemCarrito) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Item_Carrito_DeleteByIdCliente`(?);");
			cs.setInt(1, itemCarrito.getCliente().getIdCliente());
			
			cs.executeUpdate();
			
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	@Transactional(readOnly = true)
	public void deleteByIdProducto(ItemCarrito itemCarrito) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Item_Carrito_DeleteByIdProducto`(?);");
			cs.setInt(1, itemCarrito.getProducto().getIdProducto());
			
			cs.executeUpdate();
			
			conexion.commit();
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
}

class ItemCarritoWithIdClienteExtractor implements ResultSetExtractor<List<ItemCarrito>> {

	@Override
	public List<ItemCarrito> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ItemCarrito> list = new LinkedList<>();
		ItemCarrito item = null;
		while (rs.next()) {
			Integer idItemClienteActual = rs.getInt("id_cliente_item");
			item = new ItemCarrito();
			item.getCliente().setIdCliente(idItemClienteActual);
			item.getProducto().setIdProducto(rs.getInt("id_producto_item"));
			item.setCantidad(rs.getInt("cantidad"));
			list.add(item);
		}

		return list;
	}

}
