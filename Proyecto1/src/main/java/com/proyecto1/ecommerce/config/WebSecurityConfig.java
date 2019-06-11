package com.proyecto1.ecommerce.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.proyecto1.ecommerce.security.CustomUserDetailServive;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired
 private CustomUserDetailServive customUserDetailsService;
 @Autowired
 private DataSource dataSource;

 @Bean
 public PasswordEncoder passwordEncoder() {
  return new BCryptPasswordEncoder();
 }

 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
 }

 @Override
 protected void configure(HttpSecurity http) throws Exception {
  // Agregar las reglas de seguridad
  http.headers().frameOptions().sameOrigin().and().authorizeRequests()
    .antMatchers("/resources/**", "/webjars/**", "/assets/**").permitAll().antMatchers("/").permitAll()
    .antMatchers("/ecommerce/menuAdmin").hasRole("ADMIN")
    //.andMatchers("/ecommerce/addClient").hasRole("ADMIN")
    .antMatchers("/ecommerce/carrito").hasRole("CUSTOMER")
    .anyRequest().authenticated()
    .and().formLogin()
    .loginPage("/login")
    .defaultSuccessUrl("/home")
    .failureUrl("/login?error")
    .permitAll()
    .and()
    .logout()
    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    .logoutSuccessUrl("/login?logout")
    .permitAll()
    .and()
    .exceptionHandling()
    .accessDeniedPage("/accessDenied");

 }

 PersistentTokenRepository persistentTokenRepository() {
  JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
  tokenRepositoryImpl.setDataSource(dataSource);
  return tokenRepositoryImpl;
 }
}