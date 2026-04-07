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
		Genero generoDrama = new Genero("Drama");
		Genero generoSciFi = new Genero("Sci-Fi");
		Genero generoSitcom = new Genero("Sitcom");
		
		serie = new Serie("Breaking Bad", 2008);
		episodio = new Episodio("Piloto");
		
		serie.addGenero(generoDrama);
		serie.addEpisodio(episodio);
		serie.addEpisodio(new Episodio("Cat's in the Bag..."));
		serie.addEpisodio(new Episodio("...And the Bag's in the River"));
		serie.addEpisodio(new Episodio("Cancer Man"));
		generoDrama.addSerie(serie);

		manager.store(serie);
		manager.store(generoDrama);
		manager.commit();
		
		
		
		serie = new Serie("Stranger Things", 2016);
		episodio = new Episodio("O desaparecimento de Will Byers");
		
		serie.addGenero(generoSciFi);
		serie.addGenero(generoDrama);
		serie.addEpisodio(episodio);
		serie.addEpisodio(new Episodio("A estranha na Maple Street"));
		serie.addEpisodio(new Episodio("A pulga e o acrobata"));
		generoSciFi.addSerie(serie);
		generoDrama.addSerie(serie);

		manager.store(serie);
		manager.store(generoSciFi);
		manager.store(generoDrama);
		manager.commit();


		
		
		
		serie = new Serie("The Office", 2005);
		episodio = new Episodio("Pilot");
		
		serie.addGenero(generoSitcom);
		serie.addEpisodio(episodio);
		serie.addEpisodio(new Episodio("Diversity Day"));
		generoSitcom.addSerie(serie);

		manager.store(serie);
		manager.store(generoSitcom);
		manager.commit();
		
		
		
		serie = new Serie("Brooklyn Nine-Nine", 2013);
		episodio = new Episodio("Piloto");
		
		serie.addGenero(generoSitcom);
		serie.addEpisodio(episodio);
		serie.addEpisodio(new Episodio("The Tagger"));
		serie.addEpisodio(new Episodio("The Slump"));
		generoSitcom.addSerie(serie);

		manager.store(serie);
		manager.store(generoSitcom);
		manager.commit();
		
		
		
		serie = new Serie("Teen Wolf", 2011);
		episodio = new Episodio("A lua do lobo");
		
		serie.addGenero(generoDrama);
		serie.addGenero(generoSciFi);
		serie.addEpisodio(episodio);
		generoDrama.addSerie(serie);
		generoSciFi.addSerie(serie);

		manager.store(serie);
		manager.store(generoDrama);
		manager.store(generoSciFi);
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