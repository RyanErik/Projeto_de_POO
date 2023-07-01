package classe_estudante;

import classe_modalidade.*;

public class Estudante {
	
	private String nome; //nome publico
	private float nota; //nota do Enem
	
	public static void main(String[] args ) {
	}
	
	public Estudante(String nome, float nota) {
		this.nome = nome;
		this.nota = nota;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public float getNota() {
		return this.nota;
	}

}
