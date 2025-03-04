package exercicio19;

public class Aplicacao {

	public static void main(String[] args) {
		Produto[] produto = new Produto[3];
		produto[0] = new Produto("Arroz", 30.0, 50);
        produto[1] = new Produto("Feijão", 20.0, 30);
        produto[2] = new Produto("Azeite", 60.0, 20);

        Item carrinho = new Item(produto[0], 2);   
        Item carrinho2 = new Item(produto[2], 2);   

        Pedido pedido = new Pedido(Pagamento.CARTAO);
        pedido.adicionarItem(carrinho);
        pedido.adicionarItem(carrinho2);
        
        
        
        pedido.mostrarPedido();
        
	}

}
