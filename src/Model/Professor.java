package Model;

public class Professor {
	private String cpf;
	private String nome;
	private Disciplina disciplina;
	private String email;
	
	
	public Professor(String cpf, String nome, Disciplina disciplina, String email) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.disciplina = disciplina;
		this.email = email;
		
	}


	public String getCpf() {
		return cpf;
	}


	public String getNome() {
		return nome;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public String getEmail() {
		return email;
	}
	
	
}
