package trabalhoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mensagem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mensagem frame = new Mensagem(null,null,null,0);
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
	public Mensagem(ListaAmg lista, Usuario usuario, Usuario amigo, int ind) {
		
		JFrame telaAtual = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lista.setVisible(true);
				telaAtual.dispose();
				
			}
		});
		btnVoltar.setBounds(81, 328, 111, 23);
		contentPane.add(btnVoltar);
		
		textField = new JTextField();
		textField.setBounds(10, 297, 525, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane caixaTexto = new JTextPane();
		caixaTexto.setEditable(false);
		caixaTexto.setBounds(10, 11, 525, 275);
		contentPane.add(caixaTexto);
		caixaTexto.setText(usuario.mensagens.get(ind));
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				caixaTexto.setText(usuario.mensagens.get(ind) + "\n" + usuario.getNome() + ": " + textField.getText());
				usuario.mensagens.add(ind, caixaTexto.getText());
				usuario.mensagens.remove(ind + 1);
				
				textField.setText("");
				textField.requestFocus();
				
				for(int j = 0; j < amigo.amigos.size(); j++) {
					if(amigo.amigos.get(j).getId() == usuario.getId()) {
						amigo.mensagens.add(j, caixaTexto.getText());
						amigo.mensagens.remove(j + 1);
					}
				}
		}
		});
		btnEnviar.setBounds(338, 328, 111, 23);
		contentPane.add(btnEnviar);
		
	}
}
