package modelo;

import java.util.ArrayList;
import java.util.List;

public class Serie {
	private int id;
	private String nome;
	private int ano;
	private List<Episodio> episodios; 
	private List<Genero> generos;
	
	public Serie(String nome, int ano) {
		this.nome = nome;
		this.ano = ano;
		this.episodios = new ArrayList<>();
		this.generos = new ArrayList<>();
	}
	
	
	public String getNome() {
		return nome;
	}
	public int getAno() {
		return ano;
	}
	public List<Episodio> getEpisodios() {
	    return episodios;
	}
	public List<Genero> getGenero() {
	    return generos;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	public void adcEpisodio(Episodio ep) {
		this.episodios.add(ep);
	}
	public void adcGenero(Genero gen) {
		this.generos.add(gen);
	}
	
	
	@Override
	public String toString() {
		return "ID: " + id + " - " + nome + " (" + ano + ")" + " Episódios: " + episodios + " / " + generos; 
	}
}