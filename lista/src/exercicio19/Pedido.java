package exercicio19;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens;
	private int quantidade;
	private Pagamento pagamento;

	public Pedido() {
		
	}

	public Pedido(List<Produto> itens, int quantidade, Pagamento pagamento) {
		this.itens = itens;
		this.quantidade = quantidade;
		this.pagamento = pagamento;
	}
	
	public List<Produto> getItens() {
	    return new ArrayList<>(itens);
	}

    public void adicionarItem(Produto item) {
        itens.add(item);
    }

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
