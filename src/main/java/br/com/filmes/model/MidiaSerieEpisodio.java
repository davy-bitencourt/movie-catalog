/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.filmes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author dave
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MidiaSerieEpisodio(
		@JsonAlias("Title") String titulo_episodio,
		@JsonAlias("Released") String estreia,
		@JsonAlias("Episode") int episodio,
		@JsonAlias("imdbRating") String avaliacao
	) {}
