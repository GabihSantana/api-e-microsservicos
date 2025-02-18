package enums;

public enum PizzaBordaSelecao {
	CATUPIRY	("Borda de Catupiry", 8.00),
	CHEDDAR		("Borda de Cheddar", 10.00), 
	SEM			("Sem borda", 0.0);

	private String descricao;
	private Double preco;
	
	PizzaBordaSelecao(String descricao, Double preco) {
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
