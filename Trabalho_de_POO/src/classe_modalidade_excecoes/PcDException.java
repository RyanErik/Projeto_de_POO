package classe_modalidade_excecoes;

import classe_estudante.Estudante;

public class PcDException extends Exception{
	private static final long serialVersionUID = 1L;
	Estudante e;
	
	public PcDException(Estudante e) {
		super("Estudante não possui deficiencia");
		e.setExc(getCause());
	}


}
