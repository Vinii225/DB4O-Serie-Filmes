package appconsole;

import com.db4o.ObjectContainer;
import util.Util;
import modelo.Serie;
import modelo.Genero;
import modelo.Episodio;

public class Cadastrar {
	
	public Cadastrar() {
		Util.conectar();
		ObjectContainer manager = Util.getManager();
		
		System.out.println("Começo do cadastro");
		Serie serie;
		Episodio episodio;
		Genero genero;
		
		genero = new Genero("Drama");
		serie = new Serie("Breaking Bad", 2008);
		episodio = new Episodio("Piloto");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);
		
		manager.store(serie);
		manager.commit();
		
		
		
		genero = new Genero("Sci-Fi");
		serie = new Serie("Stranger Things", 2016);
		episodio = new Episodio("O desaparecimento de Will Byers");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);
		
		manager.store(serie);
		manager.commit();
		
		
		
		genero = new Genero("Sitcom");
		serie = new Serie("The Office", 2005);
		episodio = new Episodio("Pilot");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);
		
		manager.store(serie);
		manager.commit();
		
		
		
		genero = new Genero("Sitcom");
		serie = new Serie("Brooklyn Nine-Nine", 2013);
		episodio = new Episodio("Piloto");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);
		
		manager.store(serie);
		manager.commit();
		
		
		
		genero = new Genero("Drama");
		serie = new Serie("Teen Wolf", 2011);
		episodio = new Episodio("A lua do lobo");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);
		
		manager.store(serie);
		manager.commit();
		
		
		Util.desconectar();
		System.out.println("fim do programa cadastrar.java");
	}
	
	public void cadastrar() {
	
	}
	
	public static void main(String[] args) {
		new Cadastrar();
	}
}