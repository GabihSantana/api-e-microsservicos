/**
 *  Identifique	as	classes	e	implemente	um	programa	para	a	seguinte	especificação:	“O	
supermercado	vende	diferentes	tipos	de	produtos.	Cada	produto	tem	um	preço	e	uma	
quantidade	em	estoque.	Um	pedido	de	um	cliente	é	composto	de	itens,	onde	cada	item	
especifica	o	produto	que	o	cliente	deseja	e	a	respectiva	quantidade.	Esse	pedido	pode	ser	
pago	em	dinheiro,	cheque	ou	cartão.”
 */

package exercicio19;

public class Produto {
	private String nome;
	private double preco;
	private int quantidadeEstoque;

	public Produto() {

	}

	public Produto(String nome, double preco, int quantidadeEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
