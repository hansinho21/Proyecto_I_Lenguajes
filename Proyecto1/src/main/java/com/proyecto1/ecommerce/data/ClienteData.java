package com.proyecto1.ecommerce.data;

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

import com.proyecto1.ecommerce.domain.Cliente;
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
			cliente.setPassword(rs.getString("contraseña"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.getRol().setIdRol(rs.getInt("id_rol"));
			list.add(cliente);
		}

		return list;
	}

}
