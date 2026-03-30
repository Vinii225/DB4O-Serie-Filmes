package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Serie;
import modelo.Episodio;
import modelo.Genero;
import util.Util;

public class Listar {

	public Listar(){
		Util.conectar();
		ObjectContainer manager = Util.getManager();
		
		Query q;
		
		System.out.println("\nListagem de Series: ");
		q = manager.query();
		q.constrain(Serie.class);
		List<Serie> series = q.execute();
		for(Serie s: series){
			System.out.println(s);
		}
		
		
		System.out.println("\nListagem de Episódios: ");
		q = manager.query();
		q.constrain(Episodio.class);
		List<Episodio> episodios = q.execute();
		for(Episodio e: episodios){
			System.out.println(e);
		}
		
		
		System.out.println("\nListagem de Gêneros: ");
		q = manager.query();
		q.constrain(Genero.class);
		List<Genero> generos = q.execute();
		for(Genero g: generos){
			System.out.println(g);
		}
		Util.desconectar();
		
		System.out.println("\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}

		public static void main(String[] args) {
		new Listar();
	}
}
