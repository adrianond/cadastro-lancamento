package com.br.cadastro.lancamento;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CadastroLancamentoApplication {

	public static void main(String[] args) throws JsonProcessingException {
		System.setProperty("spring.config.name", "application-local");
		SpringApplication.run(CadastroLancamentoApplication.class, args);
	}

}
