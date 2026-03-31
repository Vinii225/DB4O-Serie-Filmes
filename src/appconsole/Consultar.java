package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Serie;
import util.Util;

public class Consultar {

    public Consultar() {
        Util.conectar();
        ObjectContainer manager = Util.getManager();

        int X = 2011;
        String generoX = "Drama";
        int N = 0;

        Query q;
        List<Serie> resultados;

        System.out.println("\nConsulta 1: Séries do ano X = " + X);

        q = manager.query();
        q.constrain(Serie.class);
        q.descend("ano").constrain(X);

        resultados = q.execute();

        for (Serie s : resultados) {
            System.out.println(s);
        }

        System.out.println("\nConsulta 2: Séries do gênero de nome X = " + generoX);

        q = manager.query();
        q.constrain(Serie.class);
        q.descend("generos").descend("nome").constrain(generoX);

        resultados = q.execute();

        for (Serie s : resultados) {
            System.out.println(s);
        }

        System.out.println("\nConsulta 3: Séries com mais de N episódios, N = " + N);

        q = manager.query();
        q.constrain(Serie.class);
        q.constrain(new Evaluation() {
            @Override
            public void evaluate(Candidate candidate) {
                Serie s = (Serie) candidate.getObject();
                if (s.getEpisodios() != null && s.getEpisodios().size() > N) {
                    candidate.include(true);
                } else {
                    candidate.include(false);
                }
            }
        });

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