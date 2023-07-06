package classe_modalidade;

import classe_estudante.Estudante;

public class PPIRF extends RendaFamiliar{
	public PPIRF(int vagas) {
		super(vagas);
		name = "PPI com Baixa Renda";
	}

	public Boolean verificaPPI(Estudante e){
		if(e.getEtnia() == "Branco") {
			e.setExc("PPI");
			return false;
		}
	    return true;
	}
	public String getName() {
		return name;
	}
}
