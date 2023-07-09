package classe_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classe_sisu.Sisu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public RemoveCurso(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Removendo Cursos");
		lblNewLabel.setBounds(168, 0, 130, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Universidade:");
		lblNewLabel_1.setBounds(10, 42, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado da Universidade:");
		lblNewLabel_1_1.setBounds(10, 86, 139, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome do Curso:");
		lblNewLabel_1_2.setBounds(10, 130, 139, 14);
		contentPane.add(lblNewLabel_1_2);
		
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
		
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
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
						if(sisu.procurar(nome, estado).procurar(curso) != null) {
							sisu.procurar(nome, estado).remover(curso);
							JOptionPane.showMessageDialog(null, "Curso removido com sucesso");
						}
						else {
							JOptionPane.showMessageDialog(null, "Curso nao existe");
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

