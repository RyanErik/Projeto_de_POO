package classe_interface;


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

public class RemoverUniversidade extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEstado;

	public static void main(String[] args) {
	}

	public RemoverUniversidade(Sisu sisu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remover Universidade");
		lblNewLabel.setBounds(162, 11, 132, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNome.getText().equals("") || textEstado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Caixa de texto vazia");
				}
				else {
					String nome = textNome.getText();
					String estado = textEstado.getText();
					if(sisu.procurar(nome, estado) == null) {
						JOptionPane.showMessageDialog(null, "Universidade nao existe");
					}else {
						sisu.removerInstituicao(nome, estado);
						if(sisu.procurar(nome, estado) == null) {
							JOptionPane.showMessageDialog(null, "Universidade removida com sucesso!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao remover universidade!");
						}
					}
					textNome.setText("");
					textEstado.setText("");
				}
					
					
				}
			});
		btnNewButton.setBounds(242, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o nome da Universidade:");
		lblNewLabel_1.setBounds(10, 52, 184, 14);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 77, 284, 20);
		contentPane.add(textNome);
		
		JLabel lblNewLabel_2 = new JLabel("Estado:");
		lblNewLabel_2.setBounds(10, 123, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(10, 148, 160, 20);
		contentPane.add(textEstado);
		
		
	}
}
