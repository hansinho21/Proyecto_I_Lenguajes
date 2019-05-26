package com.proyecto1.ecommerce.data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto1.ecommerce.domain.Role;
import com.proyecto1.ecommerce.domain.User;

@Repository
public class UserData {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User findByEmail(String email) {
		String selectSql = "select ur.role_id,ur.user_id, r.name as role_name, u.email,u.name,u.password from Users_Role ur, "
				+ "Role r, Users u where u.email='" + email + "' and ur.role_id=r.roler_id and ur.user_id=u.user_id";
		List<User> users=jdbcTemplate.query(selectSql, new RowMapper() {
		

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user =new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				do {
					if(rs.getString("email").equals(user.getEmail())) {
						Role role=new Role();
						role.setRoleId(rs.getInt("role_id"));
						role.setName(rs.getString("role_name"));
						user.getRoles().add(role);
					}
				}while(rs.next());
				return user;
			}//maprow
		});
		return users.isEmpty()? new User():users.get(0);
	}

}