package trabalhoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAmigo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAmigo frame = new AddAmigo(null,null,null);
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
	public AddAmigo(Usuario usuario, Menu menu, Login tela) {
		
		JFrame telaAtual = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 477, 199);
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
		
		DefaultTableModel tabela = (DefaultTableModel) table.getModel();
		for(int i=0; i < tela.contas.size(); i++) {
			tabela.addRow(new String[] {tela.contas.get(i).getNome(),tela.contas.get(i).getEmail(),tela.contas.get(i).getDataNascimento(),Integer.toString(tela.contas.get(i).getId())});
		}	
		textField = new JTextField();
		textField.setBounds(291, 221, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INFORME O ID DO USU\u00C1RIO:");
		lblNewLabel.setBounds(10, 224, 215, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				telaAtual.dispose();
			}
		});
		btnVoltar.setBounds(112, 266, 113, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAdd = new JButton("ADICIONAR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int idAmg = Integer.parseInt(textField.getText());
					
					for(int i = 0; i < tela.contas.size(); i++) {
						if(tela.contas.get(i).getId() == idAmg) {
							if(usuario.amigos.size() != 0) {
								boolean verIgual = false;
								for(int j = 0; j<usuario.amigos.size();j++) {
								
									if(tela.contas.get(i).getId() == usuario.amigos.get(j).getId()) {
										JOptionPane.showMessageDialog(btnAdd, "ESTE USUÁRIO JÁ É SEU AMIGO");
										verIgual = true;
									}
								}
								if(verIgual == false) {
									if(usuario.getId() == tela.contas.get(i).getId()) {
										JOptionPane.showMessageDialog(btnAdd, "VOCÊ NÃO PODE SE ADICIONAR A SUA LISTA DE AMIGOS");
									}else {
										usuario.adicionaAmigo(tela.contas.get(i));
										usuario.addTexto("");
										tela.contas.get(i).adicionaAmigo(usuario);
										tela.contas.get(i).addTexto("");
									}
								}
							}else{
								if(usuario.getId() == tela.contas.get(i).getId()) {
									JOptionPane.showMessageDialog(btnAdd, "VOCÊ NÃO PODE SE ADICIONAR A SUA LISTA DE AMIGOS");
								}else {
									usuario.adicionaAmigo(tela.contas.get(i));
									usuario.addTexto("");
									tela.contas.get(i).adicionaAmigo(usuario);
									tela.contas.get(i).addTexto("");
								}
							}
							textField.setText("");
							textField.requestFocus();
							
						}
					}
				}
		});
		btnAdd.setBounds(267, 266, 113, 23);
		contentPane.add(btnAdd);
		
		
	}
}
