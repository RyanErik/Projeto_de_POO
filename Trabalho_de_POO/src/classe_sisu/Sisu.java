package classe_sisu;

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import classe_instituicao.*;

public class Sisu {

	private Vector<Instituicao> listaInstituicoes;
	
	Scanner scanner = new Scanner(System.in);
    int opcao = 100;

	public Sisu() {
		listaInstituicoes = new Vector<Instituicao>();
	}

	public Instituicao procurar(String instituicao, String estado) {
		
		if (listaInstituicoes.size() <= 0) {
			return null;
		}
		
		for(int i = 0; i < listaInstituicoes.size(); i++) {
			if(listaInstituicoes.get(i).getNome().equals(instituicao) && listaInstituicoes.get(i).getEstado().equals(estado)) {				
				return listaInstituicoes.get(i);
			}
		}
		
		return null;
	}
	

	public void adicionarInstituicao(Instituicao instituicao) {
			if(procurar(instituicao.getNome(), instituicao.getEstado()) == null) {				
				listaInstituicoes.add(instituicao);
		}
	}

	public void removerInstituicao(String nome, String estado) {
			if(procurar(nome, estado) != null) {
				listaInstituicoes.remove(procurar(nome, estado));
		}
	}

	public Vector<Instituicao> listarInstituicoes() {
		    if (listaInstituicoes.isEmpty()) {
		      return null;
		    }
		    return listaInstituicoes;		
	}
	
	public void adicionarCurso(String instituicao, String estado, String nome, int vagas) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).cadastrar(nome, vagas);
		}
	}
	
	
	public void listarCursos(String instituicao, String estado) {
		if(procurar(instituicao, estado) != null) {
			procurar(instituicao, estado).imprimirLista();
		}else {
			System.out.println("Instituicao nao encontrada");
		}
	}
	
	public void listarAlunos(String instituicao, String curso, String modalidade, String estado) {
		if(procurar(instituicao, estado) != null) {
			procurar(instituicao, estado).listarAlunos(curso, modalidade);
		}else {
			System.out.println("Instituicao nao encontrada");
		}
	}
	
	
	public void removerCurso(String curso, String instituicao, String estado) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).remover(curso);
			}else {
				System.out.println("Instituicao nao encontrada");
			}
		}
	
	public void salvandoResultados(String instituicao, String estado) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).criandoArquivo();
				procurar(instituicao, estado).escrevendoArquivo();
			}else {
				System.out.println("Instituicao nao encontrada");
			}
		}
	
	public void leituraResultados(String instituicao, String estado) {
			if(procurar(instituicao, estado) != null) {
				
				File arquivo = new File(procurar(instituicao, estado).getNome() +".txt"); // Especifique o caminho e o nome do arquivo

		        try (FileReader fileReader = new FileReader(arquivo);
		             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

		            String linha;
		            while ((linha = bufferedReader.readLine()) != null) {
		                System.out.println(linha);
		            }

		        } catch (IOException e) {
		            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		        }
				
				
			}else {
				System.out.println("Instituicao nao encontrada");
			}
		}

	
	public int tamanho() {
		return listaInstituicoes.size();
	}
}
