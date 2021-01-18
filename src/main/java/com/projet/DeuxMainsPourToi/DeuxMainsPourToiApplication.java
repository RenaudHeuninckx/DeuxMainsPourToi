package com.projet.DeuxMainsPourToi;

import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.DAL.repository.UtilisateurRepository;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.UtilisateurNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;
import com.projet.DeuxMainsPourToi.metier.service.UtilisateurService;
import com.projet.DeuxMainsPourToi.presentation.UtilisateurController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class DeuxMainsPourToiApplication {

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
		}

	}

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = SpringApplication.run(DeuxMainsPourToiApplication.class, args);

		UtilisateurRepository rep = ctx.getBean(UtilisateurRepository.class);



	}

}
