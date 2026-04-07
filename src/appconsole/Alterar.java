package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Serie;
import modelo.Genero;
import util.Util;

import java.util.List;

public class Alterar {

	public Alterar(){
		Util.conectar();
		ObjectContainer manager = Util.getManager();

		Query q = manager.query();
		q.constrain(Serie.class);
		q.descend("nome").constrain("Breaking Bad");
		List<Serie> resultados = q.execute();
		
		if(resultados.size() > 0){
			Serie serie = resultados.getFirst();

			if (!serie.getGeneros().isEmpty()) {
				Genero genero = serie.getGeneros().get(0);

				serie.getGeneros().remove(genero);
				genero.getSeries().remove(serie);

				manager.store(serie);
				manager.store(genero);
				manager.commit();

				System.out.println("Relacionamento Serie-Genero removido com sucesso");
				System.out.println(serie);
			}
			else {
				System.out.println("A serie nao possui genero para remover relacionamento");
			}
		}
		else
			System.out.println("Série não localizada");
		

		
		Util.desconectar();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
	}


	//=================================================
	public static void main(String[] args) {
		new Alterar();
	}
}

