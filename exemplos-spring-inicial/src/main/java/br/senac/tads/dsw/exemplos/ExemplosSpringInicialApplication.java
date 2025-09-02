package br.senac.tads.dsw.exemplos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // @Configuration implicito
public class ExemplosSpringInicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemplosSpringInicialApplication.class, args);
	}

	// Objeto retornado passa a ser gerenciado pelo Spring
	@Bean
	public GeradorSaida geradorSaida() {
		return new GeradorSaidaJson();
	}

}
