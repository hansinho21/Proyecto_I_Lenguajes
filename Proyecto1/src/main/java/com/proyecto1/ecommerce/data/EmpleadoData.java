package com.proyecto1.ecommerce.data;

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

import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;

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
			empleado.setCorreo(rs.getString("correo"));
			empleado.setPassword(rs.getString("contraseña"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setDepartamento(rs.getString("departamento"));
			empleado.setTelefonoOficina(rs.getString("telefono_oficina"));
			empleado.getRol().setIdRol(rs.getInt("id_rol_empleado"));
			list.add(empleado);
		}

		return list;
	}

}
