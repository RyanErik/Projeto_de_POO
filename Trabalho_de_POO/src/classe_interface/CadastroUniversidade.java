package classe_interface;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classe_instituicao.Instituicao;
import classe_sisu.Sisu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUniversidade extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEstado;
	private Instituicao instituicao;
	public CadastroUniversidade(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Universidade");
		lblNewLabel.setBounds(176, 11, 177, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o nome da Universidade:");
		lblNewLabel_1.setBounds(10, 72, 184, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado:");
		lblNewLabel_2.setBounds(10, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNome = new JTextField();
		textNome.setBounds(10, 97, 284, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(10, 162, 160, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNome.getText().equals("") || textEstado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}else {
					String nome = textNome.getText();
					String estado = textEstado.getText();
					if(sisu.procurar(nome, estado) != null) {
						JOptionPane.showMessageDialog(null, "Universidade já existe");
					}
					else {
						instituicao = new Instituicao(nome, estado);
						sisu.adicionarInstituicao(instituicao);
						if(instituicao != null) {
							JOptionPane.showMessageDialog(null, "Universidade adicionada com sucesso!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao adicionar universidade!");
						}
					}
					textNome.setText("");
					textEstado.setText("");
				}
			}
		});
		btnNewButton.setBounds(260, 276, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(357, 276, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
