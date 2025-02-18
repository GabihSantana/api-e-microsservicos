package enums;

public enum PizzaMolhoSelecao {
	TOMATE		("Molho de tomate", 3.00),
	BARBECUE	("Molho barbecue", 5.00), 
	ESPECIAL	("Molho especial", 7.00);

	private String descricao;
	private Double preco;
	
	PizzaMolhoSelecao(String descricao, Double preco) {
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
