package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import util.Util;
import modelo.Serie;
import modelo.Genero;
import modelo.Episodio;

public class Cadastrar {
	
	public Cadastrar() {
		Util.conectar();
		ObjectContainer manager = Util.getManager();
		ObjectSet<Serie> existe;
		
		System.out.println("Começo do cadastro");
		Serie serie;
		Episodio episodio;
		Genero genero;
		
		genero = new Genero("Drama");
		serie = new Serie("Breaking Bad", 2008);
		episodio = new Episodio("Piloto");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		serie.adcEpisodio(new Episodio("Cat's in the Bag..."));
		serie.adcEpisodio(new Episodio("...And the Bag's in the River"));
		serie.adcEpisodio(new Episodio("Cancer Man"));
		genero.adcSerie(serie);

		existe = manager.queryByExample(new Serie("Breaking Bad", 2008));
		if (existe.isEmpty()) {
			manager.store(serie);
			manager.commit();
		}
		
		
		
		genero = new Genero("Sci-Fi");
		serie = new Serie("Stranger Things", 2016);
		episodio = new Episodio("O desaparecimento de Will Byers");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		serie.adcEpisodio(new Episodio("A estranha na Maple Street"));
		serie.adcEpisodio(new Episodio("A pulga e o acrobata"));
		genero.adcSerie(serie);

		existe = manager.queryByExample(new Serie("Stranger Things", 2016));
		if (existe.isEmpty()) {
			manager.store(serie);
			manager.commit();
		}


		
		
		
		genero = new Genero("Sitcom");
		serie = new Serie("The Office", 2005);
		episodio = new Episodio("Pilot");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		serie.adcEpisodio(new Episodio("Diversity Day"));
		genero.adcSerie(serie);

		existe = manager.queryByExample(new Serie("The Office", 2005));
		if (existe.isEmpty()) {
			manager.store(serie);
			manager.commit();
		}
		
		
		
		genero = new Genero("Sitcom");
		serie = new Serie("Brooklyn Nine-Nine", 2013);
		episodio = new Episodio("Piloto");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		serie.adcEpisodio(new Episodio("The Tagger"));
		serie.adcEpisodio(new Episodio("The Slump"));
		genero.adcSerie(serie);

		existe = manager.queryByExample(new Serie("Brooklyn Nine-Nine", 2013));
		if (existe.isEmpty()) {
			manager.store(serie);
			manager.commit();
		}
		
		
		
		genero = new Genero("Drama");
		serie = new Serie("Teen Wolf", 2011);
		episodio = new Episodio("A lua do lobo");
		
		serie.adcGenero(genero);
		serie.adcEpisodio(episodio);
		genero.adcSerie(serie);

		existe = manager.queryByExample(new Serie("Teen Wolf", 2011));
		if (existe.isEmpty()) {
			manager.store(serie);
			manager.commit();
		}
		
		
		Util.desconectar();
		System.out.println("fim do programa cadastrar.java");
	}
	
	public void cadastrar() {
	
	}
	
	public static void main(String[] args) {
		new Cadastrar();
	}
}