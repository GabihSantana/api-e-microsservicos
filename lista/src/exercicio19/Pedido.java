package exercicio19;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Item> itens;
	private Pagamento pagamento;

	public Pedido() {
		this.itens = new ArrayList<>();
	}

	public Pedido(Pagamento pagamento) {
		this.pagamento = pagamento;
		this.itens = new ArrayList<>();
	}

	public List<Item> getItens() {
		return new ArrayList<>(itens);
	}

	public void adicionarItem(Item item) {
		item.estoque(); 
		if (item.getProduto().temEstoqueSuficiente(item.getQuantidade())) {
			itens.add(item);
		} else {
			System.out.println("\nErro: Não foi possível adicionar o produto " + item.getProduto().getNome());
		}
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void mostrarPedido() {
		double preco = 0;
		System.out.println(" ********* PEDIDO **********");
		for (Item item : itens) {
			System.out.println("\n" + item);
			preco += item.getProduto().getPreco() * item.getQuantidade();
		}
		System.out.println("\n\nForma de pagamento: " + getPagamento());
		System.out.println("\n VALOR: " + preco);
	}

}
