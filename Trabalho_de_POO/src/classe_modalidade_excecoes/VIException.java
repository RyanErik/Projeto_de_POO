package classe_modalidade_excecoes;

import classe_estudante.Estudante;

public class VIException extends Exception{
	private static final long serialVersionUID = 1L;
	Estudante e;
	
	public VIException(Estudante e) {
		super("Vagas Insuficientes");
		this.e = e;
	}
	
	public String getNome(){
		return e.getNome();
	}
	
	public float getNota() {
		return e.getNota();
	}

}
