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
import com.proyecto1.ecommerce.domain.EstadoOrden;
import com.proyecto1.ecommerce.domain.Marca;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class EstadoOrdenData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<EstadoOrden> findAll() {
		String sqlSelect = "CALL `Estado_Orden_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new EstadoOrdenWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public int insert(String nombre) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Estado_Orden_Insert`(?,?);");
			cs.setString(1, nombre);
			cs.registerOutParameter(2, Types.INTEGER);
			
			cs.executeUpdate();
			
			conexion.commit();
			
			return cs.getInt(2);
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
	public void update(EstadoOrden estadoOrden) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Estado_Orden_Update`(?,?);");
			cs.setInt(1, estadoOrden.getIdEstadoOrden());
			cs.setString(2, estadoOrden.getEstadoOrden());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Estado_Orden_Delete`(?);");
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

class EstadoOrdenWithIdExtractor implements ResultSetExtractor<List<EstadoOrden>> {

	@Override
	public List<EstadoOrden> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EstadoOrden> list = new LinkedList<>();
		EstadoOrden estadoOrden = null;
		while (rs.next()) {
			Integer idEstadoOrdenActual = rs.getInt("id_estado_orden");
			estadoOrden = new EstadoOrden();
			estadoOrden.setIdEstadoOrden(idEstadoOrdenActual);
			estadoOrden.setEstadoOrden(rs.getString("estado_orden"));
			list.add(estadoOrden);
		}

		return list;
	}

}
