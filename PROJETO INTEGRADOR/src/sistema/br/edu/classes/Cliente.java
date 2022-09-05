package sistema.br.edu.classes;

public class Cliente {
	private Integer id_cliente;
	private String nome;
	private String endereco;
	private String telefone;

	public Cliente() {
	}

	public Cliente(Integer id_cliente, String nome, String telefone, String endereco) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}