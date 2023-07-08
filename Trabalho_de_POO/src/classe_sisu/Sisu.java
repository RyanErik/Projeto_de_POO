package classe_sisu;

import java.util.Scanner;
import java.util.Vector;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import classe_estudante.Estudante;
import classe_instituicao.*;

public class Sisu {

	private Vector<Instituicao> listaInstituicoes;
	private boolean estaAbertoInscricoes;
	
	Scanner scanner = new Scanner(System.in);
    int opcao = 100;

	public Sisu() {
		listaInstituicoes = new Vector<Instituicao>();
		estaAbertoInscricoes = true;
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
		if(estaAbertoInscricoes == true) {
			if(procurar(instituicao.getNome(), instituicao.getEstado()) == null) {				
				listaInstituicoes.add(instituicao);
			}
		}
	}

	public void removerInstituicao(String nome, String estado) {
		if(estaAbertoInscricoes == true) {
			if(procurar(nome, estado) != null) {
				listaInstituicoes.remove(procurar(nome, estado));
			}
		}
	}

	public Vector<Instituicao> listarInstituicoes() {
		
		if(estaAbertoInscricoes == true) {
			//Caso a lista esteja vazia
		    if (listaInstituicoes.isEmpty()) {
		      return null;
		    }
		    //Caso a lista não esteja vazia
		    return listaInstituicoes;
		}
		return null;		
	}
	
	public void adicionarCurso(String instituicao, String estado, String nome, int vagas) {
		if(estaAbertoInscricoes == true) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).cadastrar(nome, vagas);
			}
		}
	}
	
	public void adicionarEstudante(String curso, Estudante estudante, String estado) {
		if(estaAbertoInscricoes == true) {
			System.out.println("Digite a instituicao ao qual deseja cadastrar o estudante: ");
			String instituicao = scanner.next();

			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).adicionarAluno(curso, estudante);
			}else {
				System.out.println("Instituicao nao encontrada");
			}
			
			
		}else {
			System.out.println("Sisu encerrado");
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
	
	public void removerEstudante(String curso, String estudante, String modalidade, String estado) {
		if(estaAbertoInscricoes == true) {
			System.out.println("Digite a instituicao ao qual deseja remover o estudante: ");
			String instituicao = scanner.next();

			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).removerAluno(curso, estudante, modalidade);
			}else {
				System.out.println("Instituicao nao encontrada");
			}
			
			
		}else {
			System.out.println("Sisu encerrado");
		}
	}
	
	public void removerCurso(String curso, String instituicao, String estado) {
		if(estaAbertoInscricoes == true) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).remover(curso);
			}else {
				System.out.println("Instituicao nao encontrada");
			}
		}else {
			System.out.println("Sisu encerrado");
		}
	}
	
	public void salvandoResultados(String instituicao, String estado) {
		if(estaAbertoInscricoes == true) {
			if(procurar(instituicao, estado) != null) {
				procurar(instituicao, estado).criandoArquivo();
				procurar(instituicao, estado).escrevendoArquivo();
			}else {
				System.out.println("Instituicao nao encontrada");
			}
		}else {
			System.out.println("Sisu encerrado");
		}
	}
	
	public void leituraResultados(String instituicao, String estado) {
		if(estaAbertoInscricoes == false) {
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
		}else {
			System.out.println("Sisu encerrado");
		}
	}

	public boolean getEstaAbertoInscricoes() {
		return this.estaAbertoInscricoes;
	}

	public void setEstaAbertoInscricoes(boolean estaAbertoInscricoes) {
		this.estaAbertoInscricoes = estaAbertoInscricoes;
	}
	
	
	public int tamanho() {
		return listaInstituicoes.size();
	}
}
/*	
	public void iniciar (int opcao) {
            switch (opcao) {
				case 1: {
					System.out.println("Digite o nome da Instituição");
					String instituicao = scanner.nextLine();
					System.out.println("Digite o nome do Estado");
					String estado = scanner.nextLine();
					
					adicionarInstituicao(new Instituicao(instituicao, estado));	
					break;
				}
				case 2: {
					listarInstituicoes();
					break;
				}
				case 3: {
					System.out.println("Digite o nome da Instituicao a ser removida:");
					String instituicao = scanner.nextLine();
					removerInstituicao(instituicao);
					break;
				}
				case 4: {
					System.out.println("Em qual instituicao vc quer adicionar o curso");
					String name = scanner.nextLine();
					
					adicionarCurso(name);
					break;
				}case 5: {
					System.out.println("Digite o curso escolhido:");
					String curso = scanner.nextLine();
					
					System.out.println("Digite o nome do aluno:");
					String nomeAluno = scanner.nextLine();
					
					System.out.println("Digite a nota:");
					String nota = scanner.nextLine();
					
					float notaParseFloat = Float.parseFloat(nota);
					
					//modalidade
					System.out.println("Digite sua modalidade:");
					String modalidade = scanner.nextLine();
					//renda
					System.out.println("Digite a renda:");
					double renda = scanner.nextInt();
					//etnia
					System.out.println("Digite sua etnia:");
					String etnia = scanner.nextLine();
					//deficiencia
					System.out.println("Possui deficiencia:");
					boolean deficiencia = scanner.nextBoolean();
					//escola publica
					System.out.println("Escola Publica?:");
					String escolaPublica = scanner.nextLine();
					
					Estudante estudante = new Estudante(nomeAluno, notaParseFloat, modalidade, renda, etnia, deficiencia,
							 escolaPublica);
					
					adicionarEstudante(curso, estudante);
					break;
				}case 6: {
					System.out.println("Digite o curso escolhido:");
					String curso = scanner.nextLine();
					
					System.out.println("Digite o nome do Aluno:");
					String nomeAluno = scanner.nextLine();
					
					//procurar o aluno pelo nome
					System.out.println("Qual modalidade o aluno pertence");
					String modalidade = scanner.nextLine();
					
					//metodo para remover estudante
					removerEstudante(curso, nomeAluno, modalidade);
					
					break;
				}case 7: {
					//Listar Cursos
					System.out.println("Em qual instituicao vc quer Listar os cursos");
					String name = scanner.nextLine();
					
					listarCursos(name);
					break;
				}case 8: {
					//Listar alunos por curso e modalidade
					System.out.println("Em qual instituicao vc quer Listar os alunos");
					String instituicao = scanner.nextLine();
					
					System.out.println("Listar qual curso");
					String curso = scanner.nextLine();
					
					System.out.println("Listar qual modalidade");
					String modalidade = scanner.nextLine();
					
					listarAlunos(instituicao, curso, modalidade);
					break;
				}case 9: {
					System.out.println("Em qual instituicao vc quer excluir o curso");
					String curso = scanner.nextLine();
					
					System.out.println("Em qual curso vc deseja excluir");
					String instituicao = scanner.nextLine();
					
					removerCurso(curso, instituicao);
					break;
				}case 10: {
					System.out.println("Em qual instituicao vc quer Listar os cursos");
					String name = scanner.nextLine();
					
					salvandoResultados(name);
					
					break;
				}case 11: {
					setEstaAbertoInscricoes(false);
					break;
				}case 12: {
					System.out.println("Em qual instituicao vc quer Listar os cursos");
					String name = scanner.nextLine();
					leituraResultados(name);
					break;
				}
            }	
		}
	
	public static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("Opcao 1: Cadastrar Instituicoes");
        System.out.println("Opcao 2: Listar Instituicoes");
        System.out.println("Opcao 3: Remover Instituicoes");
        System.out.println("Opcao 4: Cadastrar Curso");
        System.out.println("Opcao 5: Cadastrar Estudante");
        System.out.println("Opcao 6: Remover Estudante");
        System.out.println("Opcao 7: Listar Cursos");
        System.out.println("Opcao 8: Listar Alunos");
        System.out.println("Opcao 9: Remover Curso");
        System.out.println("Opcao 10: Salvar Informacoes");
        System.out.println("Opcao 11: Encerrar periodo de inscricao");
        System.out.println("Opcao 12: Resultados");
        System.out.println("Opcao 0: Sair");
        System.out.println("Digite o numero da opcao desejada:");
	 }
}
*/