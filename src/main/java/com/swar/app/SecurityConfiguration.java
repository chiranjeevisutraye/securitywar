package com.swar.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
    public UserDetailsService userDetailsService() {
		UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("fuser").password("password").roles("FUSER").build());
        manager.createUser(users.username("suser").password("password").roles("SUSER").build());
        return manager;
    }
	
	/*@Configuration
	@Order(1)
	public static class FolderSecurity extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/rest/v1/folders/**").
			access("hasRole('FUSER')").antMatchers("/**").denyAll();
		}
	}*/
	
	//@Configuration
//	@Order(2)
	/*public static class StudentSecurity extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
	        .authorizeRequests(authorize -> authorize                                          
	            .mvcMatchers("/rest/v1/students/**").hasRole("SUSER")                            
	            .anyRequest().denyAll()                                                
	        );
			 http.httpBasic();
		}
	}*/
}
