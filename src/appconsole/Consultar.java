package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Serie;
import util.Util;

public class Consultar {

    public Consultar() {
        Util.conectar();
        ObjectContainer manager = Util.getManager();

        Query q;
        List<Serie> resultados;

        System.out.println("\nConsulta 1: Série por nome");

        q = manager.query();
        q.constrain(Serie.class);
        q.descend("nome").constrain("Breaking Bad");

        resultados = q.execute();

        for (Serie s : resultados) {
            System.out.println(s);
        }

        System.out.println("\nConsulta 2: Série por gênero");

        q = manager.query();
        q.constrain(Serie.class);
        q.descend("generos").descend("nome").constrain("Drama");

        resultados = q.execute();

        for (Serie s : resultados) {
            System.out.println(s);
        }

        System.out.println("\nConsulta 3: Série por episódio");

        q = manager.query();
        q.constrain(Serie.class);
        q.descend("episodios").descend("nome").constrain("Piloto");

        resultados = q.execute();

        for (Serie s : resultados) {
            System.out.println(s);
        }

        Util.desconectar();
        System.out.println("\nFim das consultas");
    }

    public static void main(String[] args) {
        new Consultar();
    }
}