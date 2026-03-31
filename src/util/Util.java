package util;

import java.util.Properties;
import javax.swing.JOptionPane;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import modelo.Serie;
import modelo.Episodio;
import modelo.Genero;

public class Util {
	private static ObjectContainer manager;
	private static String ipservidor;

	public static void conectar() {
		try {
			Properties props = new Properties();
			props.load(Util.class.getResourceAsStream("/util/ip.properties"));
			ipservidor = props.getProperty("ipatual");
		} catch (Exception e) {
			ipservidor = "localhost";
		}

		if(ipservidor.equals("localhost"))
			conectarBancoLocal();
		else
			conectarBancoRemoto();
		
		ControleID.ativar(manager); 
	}

	private static void conectarBancoLocal() {
		if (manager != null) return;

		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0);
		
		configurarCascata(config.common());

		try {
			manager = Db4oEmbedded.openFile(config, "banco.db4o");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar local: " + e.getMessage());
			System.exit(0);
		}
	}

	private static void conectarBancoRemoto() {
		if (manager != null) return;

		ClientConfiguration config = Db4oClientServer.newClientConfiguration();
		configurarCascata(config.common());

		try {
			manager = Db4oClientServer.openClient(config, ipservidor, 34000, "usuario1", "senha1");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar remoto: " + e.getMessage());
			System.exit(0);
		}
	}

	private static void configurarCascata(com.db4o.config.CommonConfiguration config) {
		config.objectClass(Serie.class).cascadeOnUpdate(true);
		config.objectClass(Serie.class).cascadeOnActivate(true);
		config.objectClass(Serie.class).cascadeOnDelete(true);
		
		config.objectClass(Genero.class).cascadeOnUpdate(true);
		config.objectClass(Genero.class).cascadeOnActivate(true);
	}

	public static void desconectar() {
		if (manager != null) {
			manager.close();
			manager = null;
		}
	}
	
	public static ObjectContainer getManager() {
		return manager;
	}

	public static String getIPservidor() {
		return ipservidor;
	}
}