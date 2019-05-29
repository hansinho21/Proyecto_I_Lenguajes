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
import com.proyecto1.ecommerce.domain.DetalleOrden;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.ImagenProducto;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Marca;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class DetalleOrdenData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<DetalleOrden> findAll() {
		String sqlSelect = "CALL `Detalle_Orden_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new DetalleOrdenWithIdClienteExtractor());
	}
	
	@Transactional(readOnly = true)
	public void insert(DetalleOrden detalleOrden) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Detalle_Orden_Insert`(?,?,?,?);");
			cs.setInt(1, detalleOrden.getOrden().getIdOrden());
			cs.setInt(2, detalleOrden.getProducto().getIdProducto());
			cs.setInt(3, detalleOrden.getCantidad());
			cs.setFloat(4, detalleOrden.getPrecoUnitario());
			
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
	public void updateCantidad(DetalleOrden detalleOrden) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Detalle_Orden_Update`(?,?,?,?);");
			cs.setInt(1, detalleOrden.getOrden().getIdOrden());
			cs.setInt(2, detalleOrden.getProducto().getIdProducto());
			cs.setInt(3, detalleOrden.getCantidad());
			cs.setFloat(4, detalleOrden.getPrecoUnitario());
			
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
	public void deleteByIdOrden(DetalleOrden detalleOrden) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Detalle_Orden_DeleteByIdOrden`(?);");
			cs.setInt(1, detalleOrden.getOrden().getIdOrden());
			
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
	public void deleteByIdProducto(DetalleOrden detalleOrden) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Detalle_Orden_DeleteByIdProducto`(?);");
			cs.setInt(1, detalleOrden.getProducto().getIdProducto());
			
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

class DetalleOrdenWithIdClienteExtractor implements ResultSetExtractor<List<DetalleOrden>> {

	@Override
	public List<DetalleOrden> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DetalleOrden> list = new LinkedList<>();
		DetalleOrden orden = null;
		while (rs.next()) {
			Integer idOrdenActual = rs.getInt("id_orden_detalle");
			orden = new DetalleOrden();
			orden.getOrden().setIdOrden(idOrdenActual);
			orden.getProducto().setIdProducto(rs.getInt("id_producto_detalle"));
			orden.setCantidad(rs.getInt("cantidad"));
			orden.setPrecoUnitario(rs.getFloat("precio_unitario"));
			list.add(orden);
		}

		return list;
	}

}
