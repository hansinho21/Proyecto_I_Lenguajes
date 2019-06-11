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

import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class ClienteData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		String sqlSelect = "CALL `Cliente_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new ClienteWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public Cliente findByEmail(String correo) {
		String sqlSelect = "CALL `Cliente_FindByEmail`('"+correo+"');";
		return jdbcTemplate.query(sqlSelect, new ClienteWithIdExtractor()).get(0);
	}
	
	@Transactional(readOnly = true)
	public int insert(Cliente cliente) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Cliente_Insert`(?,?,?,?,?,?);");
			cs.setString(1, cliente.getCorreo());
			cs.setString(2, cliente.getContrasenaCliente());
			cs.setString(3, cliente.getNombre());
			cs.setString(4, cliente.getApellidos());
			cs.setInt(5, cliente.getRol().getIdRol());
			cs.registerOutParameter(6, Types.INTEGER);
			
			cs.executeUpdate();
			
			conexion.commit();
			
			return cs.getInt(6);
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
	public void update(Cliente cliente) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Cliente_Update`(?,?,?,?,?,?);");
			cs.setInt(1, cliente.getIdCliente());
			cs.setString(2, cliente.getCorreo());
			cs.setString(3, cliente.getContrasenaCliente());
			cs.setString(4, cliente.getNombre());
			cs.setString(5, cliente.getApellidos());
			cs.setInt(6, cliente.getRol().getIdRol());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Cliente_Delete`(?);");
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

class ClienteWithIdExtractor implements ResultSetExtractor<List<Cliente>> {

	@Override
	public List<Cliente> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Cliente> list = new LinkedList<>();
		Cliente cliente = null;
		while (rs.next()) {
			Integer idClienteActual = rs.getInt("id_cliente");
			cliente = new Cliente();
			cliente.setIdCliente(idClienteActual);
			cliente.setCorreo(rs.getString("correo"));
			cliente.setContrasenaCliente(rs.getString("contraseña"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.getRol().setIdRol(rs.getInt("id_rol"));
			cliente.getRol().setTipo(rs.getString("tipo"));
			list.add(cliente);
		}

		return list;
	}

}
