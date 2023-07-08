package classe_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classe_curso.Curso;
import classe_instituicao.Instituicao;
import classe_sisu.Sisu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCursos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public ListarCursos(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Cursos");
		lblNewLabel.setBounds(176, 0, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Universidade");
		lblNewLabel_1.setBounds(10, 31, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado da Universidade");
		lblNewLabel_1_1.setBounds(10, 75, 134, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 253, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 90, 253, 20);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 392, 128);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}
				else {
					String nome = textField.getText();
					String estado = textField_1.getText();
					if(sisu.procurar(nome, estado) == null) {
						JOptionPane.showMessageDialog(null, "Universidade nao existe");
					}
					else {
						JList<Curso> list = new JList<Curso>(sisu.procurar(nome, estado).imprimirLista());
						scrollPane.setViewportView(list);
					}
				}
			}
		});
		btnNewButton.setBounds(313, 43, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(313, 89, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}

}
