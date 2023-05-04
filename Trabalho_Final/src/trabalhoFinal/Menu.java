package trabalhoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null,null);
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
	public Menu(Usuario usuario, Login tela) {
		JFrame telaAtual = this;
		Menu menuAtual = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListaAmigos = new JButton("LISTA DE AMIGOS");
		btnListaAmigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListaAmg(usuario,menuAtual, tela).setVisible(true);;
				telaAtual.dispose();
			}
		});
		btnListaAmigos.setBounds(135, 25, 161, 34);
		contentPane.add(btnListaAmigos);
		
		JButton btnAddAmigo = new JButton("ADICIONAR AMIGO");
		btnAddAmigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAmigo(usuario, menuAtual, tela).setVisible(true);
				telaAtual.dispose();
			}
		});
		btnAddAmigo.setBounds(135, 81, 161, 34);
		contentPane.add(btnAddAmigo);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela.limpaDados();
				tela.setVisible(true);
				telaAtual.dispose();
			}
		});
		btnSair.setBounds(135, 203, 161, 34);
		contentPane.add(btnSair);
		
		
	
	}

}
