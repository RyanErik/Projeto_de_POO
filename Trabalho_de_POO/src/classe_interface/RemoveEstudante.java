package classe_interface;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classe_sisu.Sisu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveEstudante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public RemoveEstudante(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Removendo Estudante");
		lblNewLabel.setBounds(198, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoEstudante = new JLabel("Nome do Estudante");
		lblNomeDoEstudante.setBounds(10, 36, 133, 14);
		contentPane.add(lblNomeDoEstudante);
		
		JLabel lblNomeDaUniversidade = new JLabel("Nome da Universidade");
		lblNomeDaUniversidade.setBounds(10, 77, 133, 14);
		contentPane.add(lblNomeDaUniversidade);
		
		JLabel lblEstadoDaUniversidade = new JLabel("Estado da Universidade");
		lblEstadoDaUniversidade.setBounds(10, 128, 133, 14);
		contentPane.add(lblEstadoDaUniversidade);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso");
		lblNomeDoCurso.setBounds(10, 173, 133, 14);
		contentPane.add(lblNomeDoCurso);
		
		textField = new JTextField();
		textField.setBounds(10, 49, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 97, 183, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 142, 183, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 187, 183, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Modalidade");
		lblNewLabel_1.setBounds(320, 36, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PPI Escola Publica");
		rdbtnNewRadioButton.setBounds(357, 68, 135, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ampla Concorrencia");
		rdbtnNewRadioButton_1.setBounds(222, 48, 133, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Renda Familiar");
		rdbtnNewRadioButton_2.setBounds(222, 68, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Escola Publica");
		rdbtnNewRadioButton_3.setBounds(357, 48, 177, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("PcD Escola Publica");
		rdbtnNewRadioButton_4.setBounds(357, 94, 135, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnPpiRendaFamiliar = new JRadioButton("PPI Renda Familiar");
		rdbtnPpiRendaFamiliar.setBounds(222, 94, 135, 23);
		contentPane.add(rdbtnPpiRendaFamiliar);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("PcD Renda Familiar");
		rdbtnNewRadioButton_5.setBounds(222, 113, 135, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton_5);
		grupo.add(rdbtnPpiRendaFamiliar);
		grupo.add(rdbtnNewRadioButton_4);
		grupo.add(rdbtnNewRadioButton_3);
		grupo.add(rdbtnNewRadioButton_2);
		grupo.add(rdbtnNewRadioButton_1);
		grupo.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}else {
	
					String nome = textField_1.getText();
					String estado = textField_2.getText();
					if(sisu.procurar(nome, estado) == null) {
						JOptionPane.showMessageDialog(null, "Universidade nao existe");
					}
					else {
						String curso = textField_3.getText();
						if(sisu.procurar(nome, estado).procurar(curso) != null) {
							if(rdbtnNewRadioButton_5.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PcDRF")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "PcDRF");
								}
								else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else if(rdbtnNewRadioButton_4.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PcDEP")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "PcDEP");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else if(rdbtnPpiRendaFamiliar.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PPIRF")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "PPIRF");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else if(rdbtnNewRadioButton_3.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "EP")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "EP");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else if(rdbtnNewRadioButton_2.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "RF")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "RF");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else if(rdbtnNewRadioButton_1.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "AC")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "AC");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
							else {
								if(sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PRIEP")) {
									sisu.procurar(nome, estado).procurar(curso).remover(textField.getText(), "PRIEP");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante nao existe");

								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Curso nao existe");
						}
					}
				}
			}
		});
		btnNewButton.setBounds(300, 186, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(403, 186, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
