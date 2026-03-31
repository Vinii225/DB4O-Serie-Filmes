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
			Serie ser = resultados.getFirst();

			if (!ser.getGenero().isEmpty()) {
				Genero gen = ser.getGenero().get(0);

				ser.getGenero().remove(gen);
				gen.getSeries().remove(ser);

				manager.store(ser);
				manager.store(gen);
				manager.commit();

				System.out.println("Relacionamento Serie-Genero removido com sucesso");
				System.out.println(ser);
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

