package classe_modalidade_excecoes;

import classe_estudante.Estudante;

public class PPIException extends Exception {
	private static final long serialVersionUID = 1L;
	Estudante e;

	public PPIException(Estudante e) {
		super("Estudante nao e preto, pardo ou indigena");
		this.e = e;
	}
	
	public String getNome(){
		return e.getNome();
	}
	
	public float getNota() {
		return e.getNota();
	}

}
