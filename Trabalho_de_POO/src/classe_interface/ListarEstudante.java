package classe_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classe_sisu.Sisu;
import classe_estudante.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ListarEstudante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public ListarEstudante(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Estudante");
		lblNewLabel.setBounds(173, 0, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDaUniversidade = new JLabel("Nome da Universidade");
		lblNomeDaUniversidade.setBounds(10, 36, 133, 14);
		contentPane.add(lblNomeDaUniversidade);
		
		JLabel lblEstadoDaUniversidade = new JLabel("Estado da Universidade");
		lblEstadoDaUniversidade.setBounds(10, 83, 133, 14);
		contentPane.add(lblEstadoDaUniversidade);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso");
		lblNomeDoCurso.setBounds(10, 117, 133, 14);
		contentPane.add(lblNomeDoCurso);
		
		JLabel lblNewLabel_1 = new JLabel("Modalidade");
		lblNewLabel_1.setBounds(316, 23, 109, 14);
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
		
		
		textField = new JTextField();
		textField.setBounds(10, 52, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 95, 184, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 134, 184, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 336, 83);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}else {
	
					String nome = textField.getText();
					String estado = textField_1.getText();
					if(sisu.procurar(nome, estado) == null) {
						JOptionPane.showMessageDialog(null, "Universidade nao existe");
					}
					else {
						String curso = textField_2.getText();
						if(sisu.procurar(nome, estado).procurar(curso) != null) {
							if(rdbtnNewRadioButton_5.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "PcDRF") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaPcDRF().retornaResultado());
									scrollPane.setViewportView(list);
								}
								else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

								}
							}
							else if(rdbtnNewRadioButton_4.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "PcDEP") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaPcDEP().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

								}
							}
							else if(rdbtnPpiRendaFamiliar.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "PPIRF") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaPPIRF().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

								}
							}
							else if(rdbtnNewRadioButton_3.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "EP") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaEP().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");
								}
							}
							else if(rdbtnNewRadioButton_2.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "RF") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaRF().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

								}
							}
							else if(rdbtnNewRadioButton_1.isSelected()) {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "AC") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaAC().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

								}
							}
							else {
								if(sisu.procurar(nome, estado).procurar(curso).primeiroColocado( "PRIEP") != null) {
									JList<Estudante> list = new JList<Estudante>(sisu.procurar(nome, estado).procurar(curso).getListaPPIEP().retornaResultado());
									scrollPane.setViewportView(list);
								}else {
									JOptionPane.showMessageDialog(null, "Nao tem nenhum estudante");

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
		btnNewButton.setBounds(357, 173, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(357, 207, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
