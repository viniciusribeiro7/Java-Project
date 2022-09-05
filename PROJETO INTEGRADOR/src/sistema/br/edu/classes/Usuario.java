package sistema.br.edu.classes;

public class Usuario {
	private String login;
	private String senha;
	private String nome;
	private String tipo;

	private static Usuario usuario;

	public Usuario() {

	}

	public static Usuario getInstance() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}