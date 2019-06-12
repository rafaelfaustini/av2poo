package Model;

public class Disciplina {
	private int id;
	private String nome;
	
	
	public Disciplina(String nome) {
		this.nome=nome;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
	    return this.nome;
	}
}
