package com.projet.DeuxMainsPourToi;

import com.projet.DeuxMainsPourToi.DAL.repository.UtilisateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class DeuxMainsPourToiApplication {

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable().cors().and()
					.authorizeRequests().antMatchers("/**")
					.permitAll().anyRequest().authenticated();
		}

	}

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = SpringApplication.run(DeuxMainsPourToiApplication.class, args);

		UtilisateurRepository rep = ctx.getBean(UtilisateurRepository.class);



	}

}
