package com.izibiz.training.bean.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		//provider.setPasswordEncoder(passwordEncoder());
		return provider;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/*favicon.ico", "/css /** ", "/js/**", "/images/**", "/webjars/**")
				.permitAll().antMatchers("/izibiz-training-portal/**").permitAll().antMatchers("/login").permitAll()
				.anyRequest().authenticated();

		http.formLogin().defaultSuccessUrl("/index").failureUrl("/login?error=true").defaultSuccessUrl("/index", true)
				.usernameParameter("username").passwordParameter("password")
				.successHandler(new AuthenticationSuccessHandlerImp());

		http.logout().deleteCookies("JSESSIONID");

		http.portMapper().http(80).mapsTo(443);

		http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandlerImp());

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**");
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetailsService service = new CustomUserDetailsService();

		return service;
	}

	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */


	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
