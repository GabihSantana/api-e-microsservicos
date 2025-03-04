package exercicio19;

public class Item {
	private Produto produto;
	private int quantidade;	
	
	public Item(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
    public void estoque() {
        if (produto.temEstoqueSuficiente(quantidade)) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        } else {
            System.out.println("\nQuantidade pedida maior que o estoque disponível para o produto: " + produto.getNome());
        }
    }
	
    @Override
    public String toString() {
        return getProduto() + "\nQuantidade: " + getQuantidade();
    }
	
	
}
