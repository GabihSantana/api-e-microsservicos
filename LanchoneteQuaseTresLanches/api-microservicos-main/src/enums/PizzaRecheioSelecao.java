package enums;

public enum PizzaRecheioSelecao {
	BROCOLIS	("Brócolis", 8.00),
	CAIPIRA		("Caipira", 7.00), 
	LOMBO		("Lombo", 5.00);

	private String descricao;
	private Double preco;
	
	PizzaRecheioSelecao(String descricao, Double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getDescricao() { 
		return descricao; 
	}
	
	public Double getPreco() {
		return preco;
	}
}
