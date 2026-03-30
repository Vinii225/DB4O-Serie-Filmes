package modelo;

import java.util.ArrayList;
import java.util.List;

public class Genero {
	private String nome;
	private List<Serie> series;
	
	public Genero(String nome) {
		this.nome = nome;
		this.series = new ArrayList<>();
	}
	

	public String getNome() {
		return nome;
	}
	public List<Serie> getSeries() {
		return series;
	}
		

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adcSerie(Serie serie) {
		this.series.add(serie);
	}
	
	@Override
	public String toString() {
		return "Gênero: " + nome;
	}
}