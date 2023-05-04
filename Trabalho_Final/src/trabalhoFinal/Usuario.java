package trabalhoFinal;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String senha;
	private String email; 
	private int id;
	private String dataNascimento;
	
	public Usuario(String nome, String senha, String email,  String dataNascimento) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.id = 0;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	ArrayList<Usuario> amigos = new ArrayList<>();
	
	ArrayList<String> mensagens = new ArrayList<>();
	
	public void adicionaAmigo(Usuario amigo) {
		amigos.add(amigo);
	}
	
	public void addTexto(String texto) {
		mensagens.add(texto);
	}
	
}
