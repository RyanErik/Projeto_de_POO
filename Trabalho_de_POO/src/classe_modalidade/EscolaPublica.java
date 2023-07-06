package classe_modalidade;

import classe_estudante.Estudante;

public class EscolaPublica extends AmplaConcorrencia {
	
	public EscolaPublica(int vagas) {
		super(vagas);
		name = "Escola Publica";
	}
	
	public  Boolean verificaEscolaPublica(Estudante e){
		if(e.isEscolaPublica() == "Privada") {
			e.setExc("EscolaPublica");
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}
}
