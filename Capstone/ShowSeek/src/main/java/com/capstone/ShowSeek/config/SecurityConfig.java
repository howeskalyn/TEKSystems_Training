package com.capstone.ShowSeek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
	        .authorizeRequests()
	        	// specifies all URLs that do not need authentication to view
//	        	.antMatchers("/**").permitAll() // allow all URLs
	        	.antMatchers("/events**", "/artists", "/pub/**", "/user/**", "/", "/index").permitAll()
	        	// tells spring security that all URLs can only be accessed if the user is authenticated
	        	// authentication only, no authorization (authorization implemented in the controller to limit by user role)
				.anyRequest().authenticated()
	        	.and()
	        .formLogin()
	        	// URL to the login page (request method implemented in login controller)
	        	// to display the login.jsp view
	            .loginPage("/user/login")
	            // login page will submit to with a action="/user/login" method="POST"
	            .loginProcessingUrl("/user/loginpost")
	            // spring security will send the user IF they have not requested a secure URL
	            // if they have requested a secure URL spring security will ignore this and send them to the secured url they requested
	            .defaultSuccessUrl("/profile")
	            .and()
	        .logout()
	            .invalidateHttpSession(true)
	            // log a user out
	            .logoutUrl("/user/logout")
	            // sends the browser to after the user has logged out
	            .logoutSuccessUrl("/");
	}
	

	// this is boiler plate code that can be copied and pasted into your security configuration
	@Bean(name="passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}