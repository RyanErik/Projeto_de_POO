package classe_curso;

import classe_modalidade.*;
import classe_estudante.*;

public class Curso {

  private String nomeDoCurso;
  
  private AmplaConcorrencia listaAC;
  private EscolaPublica listaEP;
  private PPIEP listaPPIEP;
  private PPIRF listaPPIRF;
  private PcDEP listaPcDEP;
  private PcDRF listaPcDRF;
  private RendaFamiliar listaRF;
  private int vagasAC;
  private int vagasEP;
  private int vagasPPIEP;
  private int vagasPPIRF;
  private int vagasPcDEP;
  private int vagasPcDRF;
  private int vagasRF;

  public Curso(String nomeDoCurso, int vagasAC, int vagasEP, int vagasPPIEP, int vagasPPIRF, int vagasPcDEP, int vagasPcDRF, int vagasRF) {
    this.setVagasAC(vagasAC);
    this.setVagasRF(vagasEP);
    this.setVagasAC(vagasPPIEP);
    this.setVagasRF(vagasPPIRF);
    this.setVagasAC(vagasPcDEP);
    this.setVagasRF(vagasPcDRF);
    this.setVagasAC(vagasRF);
    listaAC = new AmplaConcorrencia(vagasAC);
    listaEP = new EscolaPublica(vagasEP);
    listaPPIEP = new PPIEP(vagasPPIEP);
    listaPPIRF = new PPIRF(vagasPPIRF);
    listaPcDEP = new PcDEP(vagasPcDEP);
    listaPcDRF = new PcDRF(vagasPcDRF);
    listaRF = new RendaFamiliar(vagasRF);
    this.setNome(nomeDoCurso);
  }

  public void adicionar(Estudante est, String modalidade) {
	 
    if(modalidade.equals("AC"))
      listaAC.adicionaEstudante(est);
    else if(modalidade.equals("EP")) {
      listaEP.adicionaEstudante(est);
    }
    else if(modalidade.equals("PPIEP")) {
      listaPPIEP.adicionaEstudante(est);
    }
    else if(modalidade.equals("PPIRF")) {
      listaPPIRF.adicionaEstudante(est);
    }
    else if(modalidade.equals("PcDEP")) {
      listaPcDEP.adicionaEstudante(est);
    }
    else if(modalidade.equals("PcDRF")) {
      listaPcDRF.adicionaEstudante(est);
    }
    else if(modalidade.equals("RF")) {
      listaRF.adicionaEstudante(est);
    }
  }

  //Retorna true caso o aluno esteja na lista, retorna null caso contrário
  public boolean existe(String nomeEstudante, String modalidade) {
    if(modalidade.equals("AC")){
      return listaAC.existe(nomeEstudante);
    }
    else if(modalidade.equals("EP")) {
      return listaEP.existe(nomeEstudante);
    }
    else if(modalidade.equals("PPIEP")) {
      return listaPPIEP.existe(nomeEstudante);
    }
    else if(modalidade.equals("PPIRF")) {
      return listaPPIRF.existe(nomeEstudante);
    }
    else if(modalidade.equals("PcDEP")) {
      return listaPcDEP.existe(nomeEstudante);
    }
    else if(modalidade.equals("PcDRF")) {
      return listaPcDRF.existe(nomeEstudante);
    }
    else if(modalidade.equals("RF")) {
      return listaRF.existe(nomeEstudante);
    }    

    return false;
  }
  

  //remove estudante
  public void remover(String est, String modalidade) {
	
    if(modalidade.equals("AC")){
    	listaAC.remover(est);
    }
    else if(modalidade.equals("EP")) {
      listaEP.remover(est);
    }
    else if(modalidade.equals("PPIEP")) {
      listaPPIEP.remover(est);
    }
    else if(modalidade.equals("PPIRF")) {
      listaPPIRF.remover(est);
    }
    else if(modalidade.equals("PcDEP")) {
      listaPcDEP.remover(est);
    }
    else if(modalidade.equals("PcDRF")) {
      listaPcDRF.remover(est);
    }
    else if(modalidade.equals("RF")) {
      listaRF.remover(est);
    }   
         
  }

  //retorna o primeiro colocado da lista
  public Estudante primeiroColocado(String modalidade) {    

    if(modalidade == "AC") {
      return listaAC.primeiroColocado();
    }
    else if(modalidade == "EP") {
      return listaEP.primeiroColocado();
    }
    else if(modalidade == "PPIEP") {
      return listaPPIEP.primeiroColocado();
    }
    else if(modalidade == "PPIRF") {
      return listaPPIRF.primeiroColocado();
    }
    else if(modalidade == "PcDEP") {
      return listaPcDEP.primeiroColocado();
    }
    else if(modalidade == "PcDRF") {
      return listaPcDRF.primeiroColocado();
    }
    else if(modalidade == "RF") {
      return listaRF.primeiroColocado();
    }       
        
    return null;
  }

  public AmplaConcorrencia getListaAC() {
	  if(primeiroColocado("AC") != null) {
		  listaAC.Verificacao();
		  return listaAC;
	  }
	  return null;
}

public EscolaPublica getListaEP() {
	 if(primeiroColocado("EP") != null) {
		 listaEP.Verificacao();
		 return listaEP;
	 }
	 return null;
}


public PPIEP getListaPPIEP() {
	if(primeiroColocado("PPIEP") != null) {
		listaPPIEP.Verificacao();
		return listaPPIEP;
	 }
	 return null;

}

public PPIRF getListaPPIRF() {
	if(primeiroColocado("PPIRF") != null) {
		listaPPIRF.Verificacao();
		return listaPPIRF;
	 }
	 return null;

}

public PcDEP getListaPcDEP() {
	if(primeiroColocado("PcDEP") != null) {
		listaPcDEP.Verificacao();
		return listaPcDEP;
	 }
	 return null;

}

public PcDRF getListaPcDRF() {
	if(primeiroColocado("PcDRF") != null) {
		listaPcDRF.Verificacao();
		return listaPcDRF;
	 }
	 return null;

}

public RendaFamiliar getListaRF() {
	if(primeiroColocado("RF") != null) {
		listaRF.Verificacao();
		return listaRF;
	 }
	 return null;

}

  public void imprimirLista(String modalidade){
	  System.out.println("sua modalidade é: "+ modalidade);
	    if(modalidade.equals("AC")) {
	    	
	      listaAC.imprimirLista();
	    }
	    else if(modalidade.equals("EP")) {
	      listaEP.imprimirLista();
	    }
	    else if(modalidade.equals("PPIEP")) {
	      listaPPIEP.imprimirLista();
	    }
	    else if(modalidade.equals("PPIRF")) {
	      listaPPIRF.imprimirLista();
	    }
	    else if(modalidade.equals("PcDEP")) {
	      listaPcDEP.imprimirLista();
	    }
	    else if(modalidade.equals("PcDRF")) {
	      listaPcDRF.imprimirLista();
	    }
	    else if(modalidade.equals("RF")) {
	      listaRF.imprimirLista();
	    }    
	       
	  }

public String getNome() {
	return nomeDoCurso;
}

public void setNome(String nomeDoCurso) {
	this.nomeDoCurso = nomeDoCurso;
}

public int getVagasAC() {
	return vagasAC;
	
}

public void setVagasAC(int vagasAC) {
	this.vagasAC = vagasAC;
}

public int getVagasEP() {
	return vagasEP;
}

public void setVagasEP(int vagasEP) {
	this.vagasEP = vagasEP;
}

public int getVagasPPIEP() {
	return vagasPPIEP;
}

public void setVagasPPIEP(int vagasPPIEP) {
	this.vagasPPIEP = vagasPPIEP;
}

public int getVagasPPIRF() {
	return vagasPPIRF;
}

public void setVagasPPIRF(int vagasPPIRF) {
	this.vagasPPIRF = vagasPPIRF;
}

public int getVagasPcDEP() {
	return vagasPcDEP;
}

public void setVagasPcDEP(int vagasPcDEP) {
	this.vagasPcDEP = vagasPcDEP;
}

public int getVagasPcDRF() {
	return vagasPcDRF;
}

public void setVagasPcDRF(int vagasPcDRF) {
	this.vagasPcDRF = vagasPcDRF;
}

public int getVagasRF() {
	return vagasRF;
}

public void setVagasRF(int vagasRF) {
	this.vagasRF = vagasRF;
} 
@Override
public String toString() {
	return getNome();
}
  
  
}
