package com.yesh.reto;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.yesh.reto.controller.ControladorWeb;
import com.yesh.reto.model.Administrador;
import com.yesh.reto.repository.RepositorioAdministrador;
import com.yesh.reto.repository.RepositorioEmpleado;
import com.yesh.reto.repository.RepositorioJefe;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.yesh")
@EnableWebSecurity
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	private static Logger logger = LogManager.getLogger(ConfigSeguridad.class);
    
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// Lugares permitidos a cualquiera
		http
    	.authorizeRequests().antMatchers("/public/**").permitAll().and()
    	.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
    	.authorizeRequests().antMatchers("/api/**").permitAll();
		
		// Cerrar sesión
		http.logout().logoutUrl("/logout")
	      .logoutSuccessUrl("/login")
	      .invalidateHttpSession(true);
		
		// Permite la consola H2
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		// Cualquie otra solicitud se redirige al login
		http.authorizeRequests()
	      .anyRequest().authenticated()
	      .and().formLogin().permitAll();
	}
    
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  
		  // Añadir a todos los usuarios activos de la base de datos
		  auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, CLAVE AS CREDENTIALS, ACTIVO AS ENABLED FROM ADMINISTRADORES WHERE USUARIO=?"
	        ).authoritiesByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, ROL AS ROLE FROM ADMINISTRADORES WHERE USUARIO=?"
	        		).rolePrefix("ROLE_").passwordEncoder(passwordEncoder());
		  
		  auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, CLAVE AS CREDENTIALS, ACTIVO AS ENABLED FROM JEFES WHERE USUARIO=?"
	        ).authoritiesByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, ROL AS ROLE FROM JEFES WHERE USUARIO=?"
	        		).rolePrefix("ROLE_").passwordEncoder(passwordEncoder());
		  
		  auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, CLAVE AS CREDENTIALS, ACTIVO AS ENABLED FROM EMPLEADOS WHERE USUARIO=?"
	        ).authoritiesByUsernameQuery(
	        		"SELECT USUARIO AS PRINCIPAL, ROL AS ROLE FROM EMPLEADOS WHERE USUARIO=?"
	        		).rolePrefix("ROLE_").passwordEncoder(passwordEncoder());
	  }

}