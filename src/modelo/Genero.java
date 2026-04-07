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
	
	public void addSerie(Serie serie) {
		this.series.add(serie);
	}

	private String listarSeries() {
		String texto = "";
		for (int i = 0; i < series.size(); i++) {
			Serie serie = series.get(i);
			if (i > 0) {
				texto += ", ";
			}
			texto += serie.getNome() + " (" + serie.getAno() + ")";
		}
		return texto;
	}
	
	@Override
	public String toString() {
		return "Gênero: " + nome + " - Séries: [" + listarSeries() + "]";
	}
}