/*
Trabalho Final laboratório de programação de computadores ll
grrpo: João Paulo Vaz, Rafael Ribeiro, Lucoas Rocha e Otávio Rodrigues
*/

package trabalhoFinal;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeLogin;
	ArrayList<Usuario> contas = new ArrayList<>();
	private JPasswordField passwordFieldSenhaLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\otavi\\OneDrive\\Imagens\\Capturas de tela\\email.jpg"));
		setTitle("LOGIN");
		
		JFrame telaAtual = this;
		Login loginAtual = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomeLogin = new JTextField();
		textFieldNomeLogin.setBounds(120, 70, 188, 23);
		contentPane.add(textFieldNomeLogin);
		textFieldNomeLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setBounds(120, 48, 46, 14);
		contentPane.add(lblNewLabel);
		
		passwordFieldSenhaLogin = new JPasswordField();
		passwordFieldSenhaLogin.setBounds(120, 123, 188, 20);
		contentPane.add(passwordFieldSenhaLogin);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNomeLogin.getText();
				String senha = passwordFieldSenhaLogin.getText();
				int verificacao = 0;
				
				for(int i = 0; i < contas.size(); i++) {
					
					
					
					if(contas.get(i).getNome().equals(nome) == true) {
						if(contas.get(i).getSenha().equals(senha) == true) {
							
							new Menu(contas.get(i), loginAtual).setVisible(true);
							telaAtual.dispose();
							
						}else {
							
							JOptionPane.showMessageDialog(btnLogin, "SENHA INCORRETA");
						}
						
					}else {
						verificacao++;
						if(verificacao == contas.size()) {
							JOptionPane.showMessageDialog(btnLogin, "NOME INCORRETO");
						}
						
					}
					
				}
			
			}
		});
		btnLogin.setBounds(166, 175, 103, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(120, 104, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Cadastro(loginAtual).setVisible(true);
				telaAtual.dispose();
				
			}
		});
		btnCadastrar.setBounds(166, 209, 103, 23);
		contentPane.add(btnCadastrar);
		
	}
	int i = 0;
	public void addUsuario(Usuario usuarioTeste) {
		usuarioTeste.setId(i);
		this.contas.add(usuarioTeste);
		i++;
	}
	
	public void limpaDados() {
		textFieldNomeLogin.setText("");
		passwordFieldSenhaLogin.setText("");
		
	}
	
}
