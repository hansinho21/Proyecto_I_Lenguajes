package com.proyecto1.ecommerce.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto1.ecommerce.data.EmpleadoData;
import com.proyecto1.ecommerce.domain.Empleado;



@Service
@Transactional
public class CustomEmpleadoDataService implements UserDetailsService{

	@Autowired
	private EmpleadoData empleadoData;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Empleado empleado = empleadoData.findByEmail(username);
		if (empleado.getIdEmpleado() == 0) {
			throw new UsernameNotFoundException("Email " + username + " not found");
		} else {
			return new org.springframework.security.core.userdetails.User(empleado.getCorreo(), empleado.getPassword(),
					getAuthorities(empleado));
		}
	}
	
	public Collection<GrantedAuthority> getAuthorities(Empleado empleado) {
		String[] userRoles = empleado.getRol().stream().map((rol) -> rol.getTipo()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
	
}
