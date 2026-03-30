package modelo;

public class Episodio {
	private int id;
	private String nome;
	
	public Episodio(String nome) {
		this.nome = nome;
	}
	

	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
	    return "Episódio [ID:" + id + "]: " + nome;
	}
}