package br.com.filmes;

import br.com.filmes.model.Midia;
import br.com.filmes.service.ConsumoApi;
import br.com.filmes.service.ConverterDados;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("===== INICIANDO A APLICAÇÃO =====");
		try {
			SpringApplication.run(FilmesApplication.class, args);
		} catch (Exception e) {
			System.err.println("ERRO AO INICIAR SPRING BOOT: " + e);
			System.exit(1);
		}
	}

	@Override
	public void run(String... args) {
		var consumo = new ConsumoApi();
		var json = consumo.pegarDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		var conversor = new ConverterDados();

		System.out.print("Filmes: "+conversor.obterDados(json, Midia.class));
	}

	
	
}
