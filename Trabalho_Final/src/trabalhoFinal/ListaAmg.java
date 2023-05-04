package trabalhoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ListaAmg extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAmg frame = new ListaAmg(null,null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaAmg(Usuario usuario, Menu menu, Login tela) {
		
		JFrame telaAtual = this;
		ListaAmg listaAtual = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 499, 236);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Email", "Data de Nascimento", "ID"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tabelaAmg = (DefaultTableModel) table.getModel();
		for(int i=0; i < usuario.amigos.size(); i++) {
			tabelaAmg.addRow(new String[] {usuario.amigos.get(i).getNome(),usuario.amigos.get(i).getEmail(),usuario.amigos.get(i).getDataNascimento(),Integer.toString(usuario.amigos.get(i).getId())});
		}
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				telaAtual.dispose();
			}
		});
		btnVoltar.setBounds(10, 289, 98, 23);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(359, 258, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnMandarMsg = new JButton("ENVIAR MENSAGEM");
		btnMandarMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAmg = Integer.parseInt(textField.getText());
				boolean verAmg = false;
				
				for(int i = 0; i < usuario.amigos.size(); i++) {
					if(usuario.amigos.get(i).getId() == idAmg) {
						
						
						new Mensagem(listaAtual,usuario,usuario.amigos.get(i),i).setVisible(true);;
						telaAtual.dispose();
						
						
						verAmg = true;
					}
				}
				if(verAmg == false) {
					JOptionPane.showMessageDialog(btnMandarMsg, "VOCÊ NÃO É AMIGO DESTE USUÁRIO");
				}
				textField.setText("");
			}
		});
		btnMandarMsg.setBounds(149, 289, 175, 23);
		contentPane.add(btnMandarMsg);
		
		JButton btnExlcuir = new JButton("EXCLUIR AMIGO");
		btnExlcuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idAmg = Integer.parseInt(textField.getText());
				boolean verAmg = false;
				
				for(int i = 0; i < usuario.amigos.size(); i++) {
					if(usuario.amigos.get(i).getId() == idAmg) {
						
						for(int j = 0; j < tela.contas.size();j++) {
							if(tela.contas.get(j).getId() == usuario.amigos.get(i).getId()) {
								for(int k = 0; k < tela.contas.get(j).amigos.size(); k++) {
									if(tela.contas.get(j).amigos.get(k).getId() == usuario.getId()) {
										tela.contas.get(j).amigos.remove(k);
										tela.contas.get(j).mensagens.remove(k);
									}
								}
							}				
						}
						
						usuario.amigos.remove(i);
						usuario.mensagens.remove(i);
						
						textField.setText("");
						textField.requestFocus();
						verAmg = true;
					}
				}
				if(verAmg == false) {
					JOptionPane.showMessageDialog(btnExlcuir, "VOCÊ NÃO É AMIGO DESTE USUÁRIO");
				}
				
				for(int p = 0; p < usuario.amigos.size() + 1; p++) {
					tabelaAmg.removeRow(0);
				}
				for(int i=0; i < usuario.amigos.size(); i++) {
					tabelaAmg.addRow(new String[] {usuario.amigos.get(i).getNome(),usuario.amigos.get(i).getEmail(),usuario.amigos.get(i).getDataNascimento(),Integer.toString(usuario.amigos.get(i).getId())});
				}
			}
		});
		btnExlcuir.setBounds(369, 289, 140, 23);
		contentPane.add(btnExlcuir);
		
		
		JLabel lblNewLabel = new JLabel("DIGITE O ID DO AMIGO E SELECIONE A A\u00C7\u00C3O:");
		lblNewLabel.setBounds(10, 261, 254, 14);
		contentPane.add(lblNewLabel);
	}
}
