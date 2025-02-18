package enums;

public enum LanchePaoSelecao {
	AUSTRALIANO		("Pão Australiano", 5.00),
	BAGUETE			("Pão Baguete", 3.00),
	BRIOCHE			("Pão Brioche", 6.00);
	
	private String descricao;
	private Double preco;
	
	LanchePaoSelecao(String descricao, Double preco){
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
