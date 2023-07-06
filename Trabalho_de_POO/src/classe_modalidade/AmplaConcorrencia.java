package classe_modalidade;

import classe_estudante.Estudante;

public class AmplaConcorrencia extends Modalidade{
    
	public AmplaConcorrencia (int vagas){
		super(vagas);
		name = "Ampla Concorrencia";
	}
	
	public Boolean verificaRenda(Estudante e){
	    return true;
	}
	
	public  Boolean verificaEscolaPublica(Estudante e){
	    return true;
	}
	
	public Boolean verificaPPI(Estudante e){
	    return true;
	}
	
	public Boolean verificaPcD(Estudante e){
	    return true;
	}
}
