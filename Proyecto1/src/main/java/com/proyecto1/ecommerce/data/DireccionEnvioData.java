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
import com.proyecto1.ecommerce.domain.DireccionEnvio;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class DireccionEnvioData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<DireccionEnvio> findAll() {
		String sqlSelect = "CALL `Direccion_Envio_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new DireccionEnvioWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public int insert(DireccionEnvio direccionEnvio) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Direccion_Envio_Insert`(?,?,?,?,?,?,?,?);");
			cs.setString(1, direccionEnvio.getDireccion());
			cs.setString(2, direccionEnvio.getCiudad());
			cs.setString(3, direccionEnvio.getProvincia());
			cs.setInt(4, direccionEnvio.getCodigoPostal());
			cs.setString(5, direccionEnvio.getTelefono());
			cs.setString(6, direccionEnvio.getTelefono2());
			cs.setInt(7, direccionEnvio.getCliente().getIdCliente());
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
	public void update(DireccionEnvio direccionEnvio) {
		
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Direccion_Envio_Update`(?,?,?,?,?,?,?,?);");
			cs.setInt(1, direccionEnvio.getIdDireccion());
			cs.setString(2, direccionEnvio.getDireccion());
			cs.setString(3, direccionEnvio.getCiudad());
			cs.setString(4, direccionEnvio.getProvincia());
			cs.setInt(5, direccionEnvio.getCodigoPostal());
			cs.setString(6, direccionEnvio.getTelefono());
			cs.setString(7, direccionEnvio.getTelefono2());
			cs.setInt(8, direccionEnvio.getCliente().getIdCliente());
			
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
			CallableStatement cs = conexion.prepareCall("CALL `Direccion_Envio_Delete`(?);");
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

class DireccionEnvioWithIdExtractor implements ResultSetExtractor<List<DireccionEnvio>> {

	@Override
	public List<DireccionEnvio> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DireccionEnvio> list = new LinkedList<>();
		DireccionEnvio direccionEnvio = null;
		while (rs.next()) {
			Integer idDireccionEnvioActual = rs.getInt("id_direccion_envio");
			direccionEnvio = new DireccionEnvio();
			direccionEnvio.setIdDireccion(idDireccionEnvioActual);
			direccionEnvio.setDireccion(rs.getString("direccion"));
			direccionEnvio.setCiudad(rs.getString("ciudad"));
			direccionEnvio.setProvincia(rs.getString("provincia"));
			direccionEnvio.setCodigoPostal(rs.getInt("codigo_postal"));
			direccionEnvio.setTelefono(rs.getString("telefono"));
			direccionEnvio.setTelefono2(rs.getString("telefono2"));
			direccionEnvio.getCliente().setIdCliente(rs.getInt("id_cliente"));
			list.add(direccionEnvio);
		}

		return list;
	}

}
