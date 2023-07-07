package classe_instituicao;

import java.util.Vector;
import classe_curso.*;
import classe_estudante.Estudante;

public class Instituicao {
	private Vector<Curso> cursos;
	private arquivoteste arquivo;
	private String nome;
	private String estado;
	private int vagas;
	  
	public Instituicao(String nome, String estado) {
	    this.cursos = new Vector<>();
	    this.setNome(nome);
	    this.setEstado(estado);
	  }
	
	public Curso procurar(String nome){
		if (cursos.size() <= 0) {
		      return null;
		    }
		    
		for(int i = 0; i < cursos.size(); i++) {
		   if(cursos.get(i).getNome().equals(nome)) {        
		        return cursos.get(i);
		    }
		 }
		 return null;
	}
	
	public void cadastrar(String nome, int vagas){
	    if(procurar(nome) == null){
	    	Curso curso = new Curso(nome, (50*vagas)/100, (10*vagas)/100, (13*vagas)/100, (13*vagas)/100, (2*vagas)/100, (2*vagas)/100, (10*vagas)/100);
	        cursos.add(curso);
	    }
	}
	
	public void remover(String curso){
	    if(procurar(curso)!=null){
	      cursos.remove(procurar(curso));
	    }
	}
	
	public void adicionarAluno(String nome, Estudante aluno){
		Curso curso = procurar(nome);
		if(curso!= null){
			curso.adicionar(aluno, aluno.getModalidade());
		}
	 }
	 
	public void removerAluno(String nome, String aluno, String modalidade){
		Curso curso = procurar(nome);
		if(curso!= null){
			curso.remover(aluno, modalidade);
		}
	}
	 
	public void listarAlunos(String nome, String modalidade){
		Curso curso = procurar(nome);
		if(curso!= null){
			curso.imprimirLista(modalidade);
		}
	}
	 
	public Estudante primeiroAluno(String nome, String Modalidade){
			Curso curso = procurar(nome);
			if(curso!= null){
			   return curso.primeiroColocado(Modalidade);
			}
			return null;
	}
	 
	public void imprimirLista() {
			for (Curso curso : cursos) {
		        System.out.println(curso.getNome());
		    }
	}
	 
	public void criandoArquivo() {
		 arquivo = new arquivoteste();
		 arquivo.criaArquivo(getNome());		 
	 }
	 
	public void escrevendoArquivo() {
		 for(Curso curso: cursos) {
			 arquivo.cursos(curso.getNome());
			 for(int j = 0; j < 7; j++) {
				 if( j == 0 && curso.getListaAC() != null) {
					 arquivo.escreveArquivo(curso.getListaAC());
				 }
				 else if(j == 1 && curso.getListaEP() != null) {
					 arquivo.escreveArquivo(curso.getListaEP());
				 }
				 else if(j == 2 && curso.getListaRF() != null) {
					 arquivo.escreveArquivo(curso.getListaRF());
				 }
				 else if(j == 3 && curso.getListaPPIEP() != null) {
					 arquivo.escreveArquivo(curso.getListaPPIEP());
				 }
				 else if(j == 4 && curso.getListaPPIRF() != null) {
					 arquivo.escreveArquivo(curso.getListaPPIRF());
				 }
				 else if(j == 5 && curso.getListaPcDEP() != null) {
					 arquivo.escreveArquivo(curso.getListaPcDEP());
				 }
				 else if(j == 6 && curso.getListaPcDRF() != null) {
					 arquivo.escreveArquivo(curso.getListaPcDRF());
				 }
			 }
			 
		 }
	 }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
}