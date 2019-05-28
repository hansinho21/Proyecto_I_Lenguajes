package com.proyecto1.ecommerce.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class ProductoData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		String sqlSelect = "CALL `Producto_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new ProductoWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public int insert(Producto producto) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Producto_Insert`(?,?,?,?,?,?,?,?,?);");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, producto.getNombre());
			cs.setString(3, producto.getDescripcion());
			cs.setFloat(4, producto.getPrecio());
			cs.setInt(5, producto.getUnidadesExistentes());
			cs.setBoolean(6, producto.isIva());
			cs.setInt(7, producto.getDescuento());
			cs.setInt(8, producto.getMarca().getIdMarca());
			cs.setInt(9, producto.getCategoria().getIdCategoriaProducto());
			
			cs.executeUpdate();
			
			conexion.commit();
			
			return cs.getInt(1);
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
	public void update(Producto producto) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Producto_Update`(?,?,?,?,?,?,?,?,?);");
			cs.setInt(1, producto.getIdProducto());
			cs.setString(2, producto.getNombre());
			cs.setString(3, producto.getDescripcion());
			cs.setFloat(4, producto.getPrecio());
			cs.setInt(5, producto.getUnidadesExistentes());
			cs.setBoolean(6, producto.isIva());
			cs.setInt(7, producto.getDescuento());
			cs.setInt(8, producto.getMarca().getIdMarca());
			cs.setInt(9, producto.getCategoria().getIdCategoriaProducto());
			
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
	public void delete(int id) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Producto_Delete`(?);");
			cs.setInt(1, id);
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

class ProductoWithIdExtractor implements ResultSetExtractor<List<Producto>> {

	@Override
	public List<Producto> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Producto> list = new LinkedList<>();
		Producto producto = null;
		while (rs.next()) {
			Integer idProductoActual = rs.getInt("id_producto");
			producto = new Producto();
			producto.setIdProducto(idProductoActual);
			producto.setNombre(rs.getString("nombre"));
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setPrecio(rs.getFloat("precio"));
			producto.setUnidadesExistentes(rs.getInt("unidades_existentes"));
			producto.setIva(rs.getBoolean("iva"));
			producto.getMarca().setIdMarca(rs.getInt("id_marca"));
			producto.getCategoria().setIdCategoriaProducto(rs.getInt("id_categoria_producto"));
			list.add(producto);
		}

		return list;
	}

}
