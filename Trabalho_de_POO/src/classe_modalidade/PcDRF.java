package classe_modalidade;

import classe_estudante.Estudante;

public class PcDRF extends RendaFamiliar {
	public PcDRF(int vagas) {
		super(vagas);
		name = "PcD de Baixa Renda";
	}
	
	public Boolean verificaPcD(Estudante e){
		if(e.isDeficiencia() == false) {
			e.setExc("PcD");
			return false;
		}
	    return true;
	}
	public String getName() {
		return name;
	}

}
