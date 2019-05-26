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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.domain.Rol;

@Repository
public class RolData {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		String sqlSelect = "CALL `Rol_SelectAll`();";
		return jdbcTemplate.query(sqlSelect, new RolWithIdExtractor());
	}
	
	@Transactional(readOnly = true)
	public Rol insert(String tipo) {
		String sqlSelect = "CALL `Rol_Insert`('" + tipo + "');";
		return jdbcTemplate.query(sqlSelect, new RolWithIdExtractor()).get(0);
	}
	
	@Transactional(readOnly = true)
	public void delete(int id) {
		Connection conexion = null;

		try {
			conexion = dataSource.getConnection();
			conexion.setAutoCommit(false);
			CallableStatement cs = conexion.prepareCall("CALL `Rol_Delete`(?);");
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

class RolWithIdExtractor implements ResultSetExtractor<List<Rol>> {

	@Override
	public List<Rol> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Rol> list = new LinkedList<>();
		Rol rol = null;
		while (rs.next()) {
			Integer idRolActual = rs.getInt("id_rol");
			rol = new Rol();
			rol.setIdRol(idRolActual);
			rol.setTipo(rs.getString("tipo"));
			list.add(rol);
		}

		return list;
	}

}

