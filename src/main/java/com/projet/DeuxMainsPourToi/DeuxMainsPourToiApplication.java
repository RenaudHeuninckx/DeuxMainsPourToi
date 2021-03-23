package com.projet.DeuxMainsPourToi;

import com.projet.DeuxMainsPourToi.DAL.repository.UtilisateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DeuxMainsPourToiApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = SpringApplication.run(DeuxMainsPourToiApplication.class, args);

		UtilisateurRepository rep = ctx.getBean(UtilisateurRepository.class);



	}

}
