package classe_modalidade;

import java.util.Vector;
import classe_estudante.*;

public class AmplaConcorrencia{
    private Vector<Estudante> estudantes = new Vector<Estudante>();
    private int vagas;
    
	public AmplaConcorrencia(int vagas){
		setVagas(vagas);
	}
	
	public void adicionaEstudante(Estudante e) {
		 if(existe(e.getNome())) 
		        return;
		 estudantes.add(e);
	}
	
	public void OrganizaEstudante(){
		for(int i =0; i < estudantes.size() - 1; i++ ) {
			int maior = i;
			for(int j = i + 1; j < estudantes.size(); j++) {
				if(estudantes.get(j).getNota() > estudantes.get(maior).getNota()) {
					maior = j;
				}
			}
			if(maior != i) {
				Estudante temp = estudantes.get(i);
				estudantes.set(i, estudantes.get(maior));
				estudantes.set(maior, temp);
			}
		}
	}
	
	public void remover(Estudante est) {
	      //Caso o aluno não esteja na lista
	      if(procurar(est.getNome()) == null || estudantes.isEmpty()) 
	        return;
	      estudantes.remove(est);
	  }

	  //retorna o primeiro colocado da lista
	  public Estudante primeiroColocado() {
	      if (estudantes.isEmpty()) {
	        return null;
	      }
	      return estudantes.get(0);
	  }
	
	public Boolean verificaRenda(){
	    return true;
	}
	
	public  Boolean verificaEscolaPublica(){
	    return true;
	}
	
	public Boolean verificaPPI(){
	    return true;
	}
	
	public Boolean verificaPcD(){
	    return true;
	}
	
	public boolean existe(String nomeEstudante) {
	    return procurar(nomeEstudante) != null;
	  }
	  
	
	private Estudante procurar(String nomeEstudante) {
	    for (int i = 0; i < estudantes.size(); i++) {
	      if (estudantes.get(i).getNome() == nomeEstudante) {
	        return estudantes.get(i);
	      }
	    }
	    return null;
	  }
	
	public void imprimirLista() {
		for (Estudante estudante : estudantes) {
	        System.out.println(estudante.getNome() + ": " + estudante.getNota());
	    }
	}
	
	public Vector<Estudante> retornaResultado(){
	    return estudantes;
	    
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
}
