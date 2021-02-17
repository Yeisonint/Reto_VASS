package com.yesh.reto;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
    
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests().antMatchers("/public/**").permitAll().and()
	    	.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
	    	.authorizeRequests().antMatchers("/api/**").permitAll()
	    	.anyRequest().authenticated()
	    	.and().formLogin() 
	            .loginPage("/login") 
	            .failureUrl("/login-error")  
	            .permitAll();
	    http
	    	.csrf().disable();
	    http
	    	.headers().frameOptions().disable();
	}
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	// Spring Security 5 requires specifying the password storage format
//        auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
//    }
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  
		  // Añadir usuario que no esta en la base de datos como administrador (Pruebas)
		  auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("Administrador");
		  
		  // Añadir a todos los usuarios activos de la base de datos
		  auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery(
	        		"SELECT USUARIO, CLAVE, ACTIVO FROM ADMINISTRADORES "
	        		+ "UNION ALL\n"
	        		+ "SELECT USUARIO, CLAVE, ACTIVO FROM JEFES "
	        		+ "UNION ALL\n"
	        		+ "SELECT USUARIO, CLAVE, ACTIVO FROM EMPLEADOS "
	        		+ "WHERE USUARIO=?"
	        )
	        .authoritiesByUsernameQuery(
	        		"SELECT USUARIO, ROL FROM ADMINISTRADORES "
	    	    	+ "UNION ALL\n"
	    	    	+ "SELECT USUARIO, ROL FROM JEFES "
	    	    	+ "UNION ALL\n"
	    	    	+ "SELECT USUARIO, ROL FROM EMPLEADOS "
	    	    	+ "WHERE USUARIO=?"
	        		)
	        .passwordEncoder(passwordEncoder());
	  }
    
}