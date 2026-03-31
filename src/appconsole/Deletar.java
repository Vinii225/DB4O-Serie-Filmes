package appconsole;

import java.util.List;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Serie; // Importando seu modelo
import util.Util;

public class Deletar {

    public Deletar(){
        Util.conectar();
        ObjectContainer manager = Util.getManager();
        
        System.out.println("Localizando série...");
        Query q = manager.query();
        q.constrain(Serie.class);
        q.descend("nome").constrain("Breaking Bad"); 
        List<Serie> resultados = q.execute();
        
        if(resultados.size() > 0){
            Serie s = resultados.getFirst(); 
            System.out.println("localizou a série: " + s.getNome());
            
        
            manager.delete(s);
            manager.commit();
            
            System.out.println("Série e episódios deletados");
        }
        else {
            System.out.println("Série não localizada");
        }

        Util.desconectar();
        
        System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplicação");
    }

    public static void main(String[] args) {
        new Deletar();
    }
}
