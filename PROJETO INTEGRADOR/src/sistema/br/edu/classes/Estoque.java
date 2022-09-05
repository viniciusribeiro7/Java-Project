package sistema.br.edu.classes;

public class Estoque {
	private Integer id_estoque;
	private String ingrediente;
	private String tipo;
	private String fornecedor;
	private Integer quantidade;
	private Double preco;

	public Estoque() {
		super();
	}

	public Estoque(Integer id_estoque, String ingrediente, String tipo, String fornecedor, Integer quantidade,
			Double preco) {
		this.id_estoque = id_estoque;
		this.ingrediente = ingrediente;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getId_estoque() {
		return id_estoque;
	}

	public void setId_estoque(Integer id_estoque) {
		this.id_estoque = id_estoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}