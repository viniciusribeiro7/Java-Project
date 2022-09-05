package sistema.br.edu.classes;

public class Sabor {
	private Integer idsabor;
	private String nome;
	private Double preco;

	public Sabor() {
		super();
	}

	public Sabor(Integer idsabor, String nome, Double preco) {
		this.idsabor = idsabor;
		this.nome = nome;
		this.preco = preco;

	}

	public Integer getIdsabor() {
		return idsabor;
	}

	public void setIdsabor(Integer idsabor) {
		this.idsabor = idsabor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}