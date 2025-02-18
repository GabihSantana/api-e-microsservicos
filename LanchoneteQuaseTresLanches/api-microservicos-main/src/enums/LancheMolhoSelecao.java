/** 
 * Enums: Utilizado para listar os possíveis ingredientes que possam ser adicionados ao pedido, juntamente com o preço.
 * 
 */

package enums;

public enum LancheMolhoSelecao {
	BARBECUE	("Molho Barbecue", 5.00),
	TASTY		("Molho Tasty", 7.00),
	ROSE		("Molho Rosé", 4.00);
	
	private String descricao;
	private Double preco;
		
	LancheMolhoSelecao(String descricao, Double preco){
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
