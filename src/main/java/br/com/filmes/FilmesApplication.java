package br.com.filmes;

import br.com.filmes.model.MidiaSerieTemporada;
import br.com.filmes.model.MidiaSerieEpisodio;
import br.com.filmes.service.ConsumoApi;
import br.com.filmes.service.ConverterDados;
import br.com.filmes.view.Principal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FilmesApplication implements CommandLineRunner {
	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";

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
		Principal p = new Principal();
		String nome_serie = p.ler_serie();

		var consumo = new ConsumoApi();
		var json = consumo.pegarDados(ENDERECO+nome_serie+API_KEY);
		var conversor = new ConverterDados();
		var dados = conversor.obterDados(json, MidiaSerieTemporada.class);

		List<MidiaSerieTemporada> midias_temporada = new ArrayList<>();
		for(int i = 0; i <= dados.totalTemporada(); ++i){
			json = consumo.pegarDados(ENDERECO+nome_serie+"&season="+i+API_KEY);
			conversor = new ConverterDados();
			MidiaSerieTemporada dados_temporada = conversor.obterDados(json, MidiaSerieTemporada.class);
			midias_temporada.add(dados_temporada);
		}
		
		midias_temporada.forEach(System.out::println);

		List<MidiaSerieEpisodio> midias_episodios = new ArrayList();
		midias_temporada.forEach(t -> t.episodios().forEach(e -> midias_episodios.add(e)));
		midias_episodios.forEach(System.out::println);
	}

	
	
}
