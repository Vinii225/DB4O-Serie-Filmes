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
	public List<Genero> getGeneros() {
	    return generos;
	}
	public List<Genero> getGenero() {
	    return getGeneros();
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	public void addEpisodio(Episodio ep) {
		this.episodios.add(ep);
	}

	public void addGenero(Genero gen) {
		this.generos.add(gen);
	}

	private String listarGeneros() {
		String texto = "";
		for (int i = 0; i < generos.size(); i++) {
			Genero genero = generos.get(i);
			if (i > 0) {
				texto += ", ";
			}
			texto += genero.getNome();
		}
		return texto;
	}
	
	
	@Override
	public String toString() {
		return "ID: " + id + " - " + nome + " (" + ano + ")" + " Episódios: " + episodios + " / Gêneros: [" + listarGeneros() + "]"; 
	}
}