package enums;

public enum SalgadoRecheioSelecao {
	BROCOLIS	("Brócolis", 3.00),
	FRANGO		("Frango", 2.00),
	CARNE		("Carne", 2.50);
	
	private String descricao;
	private Double preco;
	
	SalgadoRecheioSelecao(String descricao, Double preco){
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
