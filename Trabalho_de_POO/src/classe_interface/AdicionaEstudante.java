package classe_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classe_estudante.Estudante;
import classe_sisu.Sisu;

public class AdicionaEstudante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String Etnia;
	private Boolean Deficiencia;
	private String Ensino;
	private double Renda;
	private float Nota;
	private JTextField textField_5;


	public AdicionaEstudante(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionando Estudante");
		lblNewLabel.setBounds(229, 0, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoEstudante = new JLabel("Nome do Estudante");
		lblNomeDoEstudante.setBounds(44, 24, 133, 14);
		contentPane.add(lblNomeDoEstudante);
		
		JLabel lblNomeDaUniversidade = new JLabel("Nome da Universidade");
		lblNomeDaUniversidade.setBounds(251, 117, 133, 14);
		contentPane.add(lblNomeDaUniversidade);
		
		JLabel lblEstadoDaUniversidade = new JLabel("Estado da Universidade");
		lblEstadoDaUniversidade.setBounds(240, 159, 133, 14);
		contentPane.add(lblEstadoDaUniversidade);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso");
		lblNomeDoCurso.setBounds(251, 206, 133, 14);
		contentPane.add(lblNomeDoCurso);
		
		textField = new JTextField();
		textField.setBounds(10, 49, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 130, 183, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(215, 175, 183, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(215, 218, 183, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Modalidade");
		lblNewLabel_1.setBounds(473, 25, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PPI Escola Publica");
		rdbtnNewRadioButton.setBounds(440, 150, 120, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ampla Concorrencia");
		rdbtnNewRadioButton_1.setBounds(440, 48, 133, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Renda Familiar");
		rdbtnNewRadioButton_2.setBounds(440, 96, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Escola Publica");
		rdbtnNewRadioButton_3.setBounds(440, 71, 135, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("PcD Escola Publica");
		rdbtnNewRadioButton_4.setBounds(440, 176, 135, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnPpiRendaFamiliar = new JRadioButton("PPI Renda Familiar");
		rdbtnPpiRendaFamiliar.setBounds(440, 124, 135, 23);
		contentPane.add(rdbtnPpiRendaFamiliar);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("PcD Renda Familiar");
		rdbtnNewRadioButton_5.setBounds(440, 205, 135, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton_5);
		grupo.add(rdbtnPpiRendaFamiliar);
		grupo.add(rdbtnNewRadioButton_4);
		grupo.add(rdbtnNewRadioButton_3);
		grupo.add(rdbtnNewRadioButton_2);
		grupo.add(rdbtnNewRadioButton_1);
		grupo.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("Etnia");
		lblNewLabel_2.setBounds(65, 168, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton branco = new JRadioButton("Branco");
		branco.setBounds(2, 189, 109, 23);
		contentPane.add(branco);
		
		JRadioButton pardo = new JRadioButton("Pardo");
		pardo.setBounds(2, 217, 109, 23);
		contentPane.add(pardo);
		
		JRadioButton preto = new JRadioButton("Preto");
		preto.setBounds(109, 189, 89, 23);
		contentPane.add(preto);
		
		JRadioButton indigena = new JRadioButton("Indígena");
		indigena.setBounds(109, 217, 89, 23);
		contentPane.add(indigena);
		
		ButtonGroup etnia = new ButtonGroup();
		etnia.add(branco);
		etnia.add(indigena);
		etnia.add(pardo);
		etnia.add(preto);
		
		JLabel lblNewLabel_3 = new JLabel("Ensino");
		lblNewLabel_3.setBounds(268, 75, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton publico = new JRadioButton("Público");
		publico.setBounds(215, 96, 89, 23);
		contentPane.add(publico);
		
		JRadioButton privado = new JRadioButton("Privado");
		privado.setBounds(310, 96, 109, 23);
		contentPane.add(privado);
		
		ButtonGroup ensino = new ButtonGroup();
		ensino.add(publico);
		ensino.add(privado);
		
		JLabel lblNewLabel_4 = new JLabel("Deficiencia");
		lblNewLabel_4.setBounds(263, 25, 99, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton sim = new JRadioButton("Sim");
		sim.setBounds(217, 48, 76, 23);
		contentPane.add(sim);
		
		JRadioButton nao = new JRadioButton("Não");
		nao.setBounds(310, 48, 109, 23);
		contentPane.add(nao);
		
		ButtonGroup deficiencia = new ButtonGroup();
		deficiencia.add(nao);
		deficiencia.add(sim);
		
		JLabel lblNewLabel_5 = new JLabel("Renda Familiar");
		lblNewLabel_5.setBounds(54, 128, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 147, 183, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nota do Enem");
		lblNewLabel_6.setBounds(52, 75, 78, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 97, 183, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
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
							if(branco.isSelected()) {
								Etnia = "Branco";
							}
							else if(preto.isSelected()) {
								Etnia = "Preto";
								
							}else if(pardo.isSelected()) {
								Etnia = "Pardo";
							}else {
								Etnia = "Indigena";
							}
							if(sim.isSelected()) {
								Deficiencia = true;
							}else if(nao.isSelected()){
								Deficiencia = false;
							}
							if(publico.isSelected()) {
								Ensino = "Publico";
							}else if(privado.isSelected()) {
								Ensino = "Privado";
							}
							Renda = Double.parseDouble(textField_4.getText());
							Nota = Float.parseFloat(textField_5.getText());
							Estudante estudante = new Estudante(textField.getText(), Nota, Renda, Etnia, Deficiencia, Ensino );
							if(rdbtnNewRadioButton_5.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PcDRF")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "PcDRF");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}
								else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else if(rdbtnNewRadioButton_4.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PcDEP")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "PcDEP");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else if(rdbtnPpiRendaFamiliar.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PPIRF")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "PPIRF");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else if(rdbtnNewRadioButton_3.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "EP")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "EP");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else if(rdbtnNewRadioButton_2.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "RF")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "RF");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else if(rdbtnNewRadioButton_1.isSelected()) {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "AC")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "AC");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

								}
							}
							else {
								if(!sisu.procurar(nome, estado).procurar(curso).existe(textField.getText(), "PRIEP")) {
									sisu.procurar(nome, estado).procurar(curso).adicionar(estudante, "PRIEP");
									JOptionPane.showMessageDialog(null, "Estudante adicionado com sucesso");
								}else {
									JOptionPane.showMessageDialog(null, "Estudante ja existe");

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
		btnNewButton.setBounds(327, 253, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(471, 253, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
	}
