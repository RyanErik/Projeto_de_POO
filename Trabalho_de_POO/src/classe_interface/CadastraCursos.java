package classe_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classe_sisu.Sisu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastraCursos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args) {
		
	}
	
	public CadastraCursos(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionando Cursos");
		lblNewLabel.setBounds(164, 11, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Universidade:");
		lblNewLabel_1.setBounds(10, 42, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado da Universidade:");
		lblNewLabel_1_1.setBounds(10, 86, 139, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome da Curso:");
		lblNewLabel_1_2.setBounds(10, 130, 139, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantidade de Vagas");
		lblNewLabel_1_3.setBounds(10, 179, 139, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(10, 56, 267, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 99, 267, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 148, 267, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 196, 267, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}
				else {
					String nome = textField.getText();
					String estado = textField_1.getText();
					if(sisu.procurar(nome, estado) == null) {
						JOptionPane.showMessageDialog(null, "Universidade nao existe");
					}
					else {
						String curso = textField_2.getText();
						int vagas = Integer.parseInt(textField_3.getText());
						if(sisu.procurar(nome, estado).procurar(curso) == null) {
							sisu.procurar(nome, estado).cadastrar(curso, vagas);
							JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
						}
						else {
							JOptionPane.showMessageDialog(null, "Curso ja existe");
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(335, 55, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(335, 98, 89, 23);
		contentPane.add(btnFechar);
	}

}
