package enums;

public enum SalgadoMassaSelecao {
	FRITA	("Frita", 5.00),
	ASSADA	("Assada", 3.00);
	
	private String descricao;
	private Double preco;
	
	SalgadoMassaSelecao(String descricao, Double preco){
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
