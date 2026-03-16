/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.filmes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author dave
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MidiaSerieTemporada(
		@JsonAlias("Title") String titulo, 
		@JsonAlias("Year") String ano,
		@JsonAlias("Season") int temporada,
		@JsonAlias("totalSeasons") int totalTemporada,
		@JsonAlias("Episodes") List<MidiaSerieEpisodio> episodios
	) {}
