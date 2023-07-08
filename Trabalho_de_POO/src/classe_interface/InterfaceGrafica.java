package classe_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import classe_sisu.Sisu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGrafica {

	private JFrame frame;
	private Sisu sisu = new Sisu();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
				 e.printStackTrace();
				}
			}
		});
	}
	

	public InterfaceGrafica() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar Universidade");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CadastroUniversidade window = new CadastroUniversidade(sisu);
					window.setVisible(true);
			}
		});
		btnNewButton.setBounds(60, 60, 167, 52);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SISU");
		lblNewLabel.setBounds(318, 29, 53, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Remover Universidade");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverUniversidade window = new RemoverUniversidade(sisu);
				window.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(248, 60, 167, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Listar Universidade");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sisu.listarInstituicoes() != null) {
					ListarUniversidade window = new ListarUniversidade(sisu);
					window.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nao tem nenhuma universidade!");
				}
				
			}
		});
		btnNewButton_1_1.setBounds(436, 60, 167, 52);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnAdicionarCurso = new JButton("Adicionar Curso");
		btnAdicionarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sisu.listarInstituicoes() != null) {
					CadastraCursos window = new CadastraCursos(sisu);
					window.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nao tem nenhuma universidade!");
				}
			}
		});
		btnAdicionarCurso.setBounds(60, 123, 167, 52);
		frame.getContentPane().add(btnAdicionarCurso);
		
		JButton btnNewButton_1_2 = new JButton("Remover Curso");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sisu.listarInstituicoes() != null) {
					RemoveCurso window = new RemoveCurso(sisu);
					window.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nao tem nenhuma universidade!");
				}
				
			}
		});
		btnNewButton_1_2.setBounds(248, 123, 167, 52);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Listar Curso");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sisu.listarInstituicoes() != null) {
					ListarCursos window = new ListarCursos(sisu);
					window.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nao tem nenhuma universidade!");
				}
			}
		});
		btnNewButton_1_1_1.setBounds(436, 123, 167, 52);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnAdicionarEstudante = new JButton("Adicionar Estudante");
		btnAdicionarEstudante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarEstudante.setBounds(60, 186, 167, 52);
		frame.getContentPane().add(btnAdicionarEstudante);
		
		JButton btnRemoverEstudante = new JButton("Remover Estudante");
		btnRemoverEstudante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sisu.listarInstituicoes() != null) {
					RemoveEstudante window = new RemoveEstudante(sisu);
					window.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nao tem nenhuma universidade!");
				}
				
			}
		});
		btnRemoverEstudante.setBounds(248, 186, 167, 52);
		frame.getContentPane().add(btnRemoverEstudante);
		
		JButton btnListarEstudantes = new JButton("Listar Estudantes");
		btnListarEstudantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListarEstudantes.setBounds(436, 186, 167, 52);
		frame.getContentPane().add(btnListarEstudantes);
	}
}
