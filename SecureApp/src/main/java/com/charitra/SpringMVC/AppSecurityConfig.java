package com.charitra.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfiguration{
		
	
		/* This is done when you dont want to connect database for username and password*/
//		@Bean
//		protected UserDetailsService userDetailsService()
//		{
//			List<UserDetails> users = new ArrayList<>();
//			users.add(User.builder().username("Charitra").password(passwordEncoder().encode("1234")).roles("USER").build());
//			return new InMemoryUserDetailsManager(users);
//		}
//	
//		@Bean
//		protected PasswordEncoder passwordEncoder()
//		{
//			return new BCryptPasswordEncoder();
//		}
	
		@Autowired
		private UserDetailsService userDetailsService;
		
		@Bean
		public AuthenticationProvider<?> authenticationProvider()
		{
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(userDetailsService);
			provider.setPasswordEncoder(new BCryptPasswordEncoder());
			return (AuthenticationProvider<?>) provider;
		}
		
		
//		protected void configure(HttpSecurity http) throws Exception{
//			http.
//			csrf().disable()
//			.authorizeRequests().antMatchers("/login").permitAll()
//			.and()
//			.formLogin()
//			.loginPage("/login").permitAll()
//			.and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/logout-success").permitAll();
//		}
}
