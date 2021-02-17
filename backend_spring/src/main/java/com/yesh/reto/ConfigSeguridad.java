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
		    .authorizeRequests()  
	        .antMatchers( "/public/**").permitAll()  
	        .anyRequest().authenticated()  
	            .and()  
	        .formLogin() 
	            .loginPage("/login")  
	            .failureUrl("/login-error")  
	            .permitAll(); 
	    http.csrf()
        	.ignoringAntMatchers("/h2-console/**");
	    
	    http.headers()
        	.frameOptions()
        	.sameOrigin();
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
		  
		  auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		  auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select USUARIO, CLAVE, ACTIVO from ADMINISTRADORES where USUARIO=?")
	        .authoritiesByUsernameQuery("select USUARIO, ROL from ADMINISTRADORES where USUARIO=?")
	        .passwordEncoder(passwordEncoder());
	  }
    
}