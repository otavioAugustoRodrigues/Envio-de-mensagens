package trabalhoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeCadastro;
	private JTextField textFieldEmailCadastro;
	private JTextField textFieldDataNascimento;
	private JPasswordField passwordFieldSenhaCadastro;
	Usuario usuario1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			
			public void run() {
				try {
					Cadastro frame = new Cadastro(null);
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
	public Cadastro(Login tela) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomeCadastro = new JTextField();
		textFieldNomeCadastro.setBounds(271, 25, 190, 20);
		contentPane.add(textFieldNomeCadastro);
		textFieldNomeCadastro.setColumns(10);
		
		textFieldEmailCadastro = new JTextField();
		textFieldEmailCadastro.setBounds(271, 65, 190, 20);
		contentPane.add(textFieldEmailCadastro);
		textFieldEmailCadastro.setColumns(10);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setBounds(271, 151, 190, 20);
		contentPane.add(textFieldDataNascimento);
		textFieldDataNascimento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setBounds(10, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		passwordFieldSenhaCadastro = new JPasswordField();
		passwordFieldSenhaCadastro.setBounds(271, 110, 190, 20);
		contentPane.add(passwordFieldSenhaCadastro);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL: ");
		lblNewLabel_1.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA:");
		lblNewLabel_2.setBounds(10, 113, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DATA DE NASCIMENTO:");
		lblNewLabel_3.setBounds(10, 154, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		JFrame telaAtual = this;
		
		JButton btnNewButtonPronto = new JButton("Pronto");
		btnNewButtonPronto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNomeCadastro.getText().trim();
				String senha = passwordFieldSenhaCadastro.getText().trim();
				String email = textFieldEmailCadastro.getText().trim();
				String dataNascimento = textFieldDataNascimento.getText().trim();
				
				
				usuario1 = new Usuario(nome,senha,email,dataNascimento);
				
				
				tela.addUsuario(usuario1);
				tela.limpaDados();
				tela.setVisible(true);
				telaAtual.dispose();
			}
		});
		btnNewButtonPronto.setBounds(173, 216, 120, 29);
		contentPane.add(btnNewButtonPronto);
		
		
	}
}
