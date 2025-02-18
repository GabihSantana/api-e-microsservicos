package enums;

public enum LancheRecheioSelecao {
	XBURGUER	("X-Burguer", 5.00),
	XSALADA		("X-Salada", 3.00),
	XTUDO		("X-Tudo", 8.00);
	
	private String descricao;
	private Double preco;
	
	LancheRecheioSelecao(String descricao, Double preco){
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
