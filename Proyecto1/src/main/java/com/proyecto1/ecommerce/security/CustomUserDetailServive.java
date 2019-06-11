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

import com.proyecto1.ecommerce.data.ClienteData;
import com.proyecto1.ecommerce.domain.Cliente;

@Service
@Transactional
public class CustomUserDetailServive implements UserDetailsService {

 @Autowired
 private ClienteData clienteData;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  Cliente cliente = clienteData.findByEmail(username);
  if (cliente.getIdCliente() == 0) {
   throw new UsernameNotFoundException("Email " + username + " not found");
  } else {
   return new org.springframework.security.core.userdetails.User(cliente.getCorreo(), cliente.getContrasenaCliente(),
     getAuthorities(cliente));
  }
 }

 public Collection<GrantedAuthority> getAuthorities(Cliente cliente) {
  String[] userRol =new String [1];//.stream().map((role) -> role.getName()).toArray(String[]::new);
  userRol[0]=cliente.getRol().getTipo().toString();
  Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRol);
  return authorities;
 }

}