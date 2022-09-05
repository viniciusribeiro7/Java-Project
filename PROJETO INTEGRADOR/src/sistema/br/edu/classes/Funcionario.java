package sistema.br.edu.classes;

public class Funcionario {
	private Integer idfuncionario;
	private String nome;
	private String funcao;
	private String telefone;
	private String endereco;

	public Funcionario() {
		super();
	}

	public Funcionario(Integer idfuncionario, String nome, String funcao, String telefone, String endereco) {
		this.idfuncionario = idfuncionario;
		this.nome = nome;
		this.funcao = funcao;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Integer getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(Integer idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}