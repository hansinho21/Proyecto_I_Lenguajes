package com.proyecto1.ecommerce.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Orden;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class OrdenData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Orden> findAll() {
		String sqlSelect = "CALL `Orden_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new OrdenWithIdExtractor());
	}
	
	
	@Transactional(readOnly = true)
	public int insert(Orden orden) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Orden_Insert`(?,?,?,?,?,?,?,?);");
			cs.setDate(1, (Date) orden.getFechaOrden());
			cs.setDate(2, (Date) orden.getFechaEnvio());
			cs.setFloat(3, orden.getValorEnvio());
			cs.setFloat(4, orden.getValorProductos());
			cs.setFloat(5, orden.getValorTotal());
			cs.setInt(6, orden.getCliente().getIdCliente());
			cs.setInt(7, orden.getEstadoOrden().getIdEstadoOrden());
			cs.registerOutParameter(8, Types.INTEGER);
			
			cs.executeUpdate();
			
			conexion.commit();
			
			return cs.getInt(8);
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
	public void update(Orden orden) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Orden_Update`(?,?,?,?,?,?,?,?);");
			cs.setInt(1, orden.getIdOrden());
			cs.setDate(2, (Date) orden.getFechaOrden());
			cs.setDate(3, (Date) orden.getFechaEnvio());
			cs.setFloat(4, orden.getValorEnvio());
			cs.setFloat(5, orden.getValorProductos());
			cs.setFloat(6, orden.getValorTotal());
			cs.setInt(7, orden.getCliente().getIdCliente());
			cs.setInt(8, orden.getEstadoOrden().getIdEstadoOrden());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Orden_Delete`(?);");
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

class OrdenWithIdExtractor implements ResultSetExtractor<List<Orden>> {

	@Override
	public List<Orden> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Orden> list = new LinkedList<>();
		Orden orden = null;
		while (rs.next()) {
			Integer idOrdenActual = rs.getInt("id_orden");
			orden = new Orden();
			orden.setIdOrden(idOrdenActual);
			orden.setFechaOrden(rs.getDate("fecha_orden"));
			orden.setFechaEnvio(rs.getDate("fecha_envio"));
			orden.setValorEnvio(rs.getFloat("valor_envio"));
			orden.setValorProductos(rs.getFloat("valor_productos"));
			orden.setValorTotal(rs.getFloat("valor_total"));
			orden.getCliente().setIdCliente(rs.getInt("id_cliente_orden"));
			orden.getEstadoOrden().setIdEstadoOrden(rs.getInt("id_estado_orden"));
			list.add(orden);
		}

		return list;
	}

}
