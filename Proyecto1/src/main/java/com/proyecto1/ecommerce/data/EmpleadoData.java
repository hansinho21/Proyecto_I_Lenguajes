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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class EmpleadoData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		String sqlSelect = "CALL `Empleado_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new EmpleadoWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public Empleado findByEmail(String correo) {
		String sqlSelect = "CALL `Empleado_FindByEmail`('"+correo+"');";
		return jdbcTemplate.query(sqlSelect, new EmpleadoWithIdExtractor()).get(0);
	}
	
	@Transactional(readOnly = true)
	public int insert(Empleado empleado) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Empleado_Insert`(?,?,?,?,?,?,?,?);");
			cs.setString(1, empleado.getCorreoEmpleado());
			cs.setString(2, empleado.getContrasenaEmpleado());
			cs.setString(3, empleado.getNombreEmpleado());
			cs.setString(4, empleado.getApellidosEmpleado());
			cs.setString(5, empleado.getDepartamento());
			cs.setString(6, empleado.getTelefonoOficina());
			cs.setInt(7, empleado.getRol().getIdRol());
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
	public void update(Empleado empleado) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Empleado_Update`(?,?,?,?,?,?,?,?);");
			cs.setInt(1, empleado.getIdEmpleado());
			cs.setString(2, empleado.getCorreoEmpleado());
			cs.setString(3, empleado.getContrasenaEmpleado());
			cs.setString(4, empleado.getNombreEmpleado());
			cs.setString(5, empleado.getApellidosEmpleado());
			cs.setString(6, empleado.getDepartamento());
			cs.setString(7, empleado.getTelefonoOficina());
			cs.setInt(8, empleado.getRol().getIdRol());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Empleado_Delete`(?);");
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

class EmpleadoWithIdExtractor implements ResultSetExtractor<List<Empleado>> {

	@Override
	public List<Empleado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Empleado> list = new LinkedList<>();
		Empleado empleado = null;
		while (rs.next()) {
			Integer idEmpleadoActual = rs.getInt("id_empleado");
			empleado = new Empleado();
			empleado.setIdEmpleado(idEmpleadoActual);
			empleado.setCorreoEmpleado(rs.getString("correo"));
			empleado.setContrasenaEmpleado(rs.getString("contraseña"));
			empleado.setNombreEmpleado(rs.getString("nombre"));
			empleado.setApellidosEmpleado(rs.getString("apellidos"));
			empleado.setDepartamento(rs.getString("departamento"));
			empleado.setTelefonoOficina(rs.getString("telefono_oficina"));
			empleado.getRol().setIdRol(rs.getInt("id_rol_empleado"));
			list.add(empleado);
		}

		return list;
	}

}
