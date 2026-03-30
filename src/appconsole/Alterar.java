package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Serie;
import modelo.Episodio;
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
			Serie ser = resultados.getFirst();
			Episodio epi = ser.getEpisodios().get(0);
			epi.setNome("Piloto (Versão Estendida");
			
			System.out.println("Episódio da série atualizado");
			System.out.println(ser);
			
			manager.store(ser);
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

