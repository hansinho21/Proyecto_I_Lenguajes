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

import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.ImagenProducto;
import com.proyecto1.ecommerce.domain.Marca;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class ImagenProductoData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<ImagenProducto> findAll() {
		String sqlSelect = "CALL `Imagen_Producto_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new ImagenProductoWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public int insert(ImagenProducto imagenProducto) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Imagen_Producto_Insert`(?,?,?);");
			cs.setString(1, imagenProducto.getImagen());
			cs.setInt(2, imagenProducto.getProducto().getIdProducto());
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.executeUpdate();
			
			conexion.commit();
			
			return cs.getInt(3);
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
	public void update(ImagenProducto imagenProducto) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Imagen_Producto_Update`(?,?,?);");
			cs.setInt(1, imagenProducto.getId());
			cs.setString(2, imagenProducto.getImagen());
			cs.setInt(3, imagenProducto.getProducto().getIdProducto());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Imagen_Producto_Delete`(?);");
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

class ImagenProductoWithIdExtractor implements ResultSetExtractor<List<ImagenProducto>> {

	@Override
	public List<ImagenProducto> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ImagenProducto> list = new LinkedList<>();
		ImagenProducto imagen = null;
		while (rs.next()) {
			Integer idImagenActual = rs.getInt("id_imagen_producto");
			imagen = new ImagenProducto();
			imagen.setId(idImagenActual);
			imagen.setImagen(rs.getString("imagen_producto"));
			imagen.getProducto().setIdProducto(rs.getInt("id_producto"));
			list.add(imagen);
		}

		return list;
	}

}
