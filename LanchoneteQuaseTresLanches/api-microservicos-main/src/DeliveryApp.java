
/**
 * <h1> Lanchonete Quase Três Lanches </h1>
 * 
 * Tela do Aplicativo. Possui o menu principal do delivery 
 * 
 * @param prato Armazena o numero do item do menu que o cliente deseja pedir
 * @param continuar Mantém o loop do menu
 * 
 * @author Gabriela Santana
 * @since 12/02/2025
 */

import java.util.Scanner;

import entidades.Caixa;
import entidades.Lanche;
import entidades.Pedido;
import entidades.Pizza;
import entidades.Salgadinho;

public class DeliveryApp {
	public static void main(String args[]) {
		int prato;

		boolean continuar = true;

		System.out.println("\t ******** Bem-Vindo ao delivery da Lanchonete Quase Três Lanches! ********");
		Pedido pedido = new Pedido();

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n Digite seu nome: ");
		String nome = scanner.next();
		pedido.setNomeCliente(nome);

		System.out.println("Olá " + pedido.getNomeCliente());

		// Menu principal do programa
		do {
			try {
				System.out.println(" Faça um pedido: \n");
				System.out.println(" 1 - Pizza \n 2 - Lanches \n 3 - Salgadinhos \n 4 - Finalizar Pedido");
				prato = scanner.nextInt();
				scanner.nextLine();

				// switch com as escolhas do usuário
				switch (prato) {
				case 1:
					Pizza pizza = new Pizza();

					System.out.println("Pizza");
					pizza.escolherMolho();
					pizza.escolherRecheio();
					pizza.escolherBorda();
					pizza.confirmaPizza();

					pedido.addItemConsumido(pizza);

					break;

				case 2:
					Lanche lanche = new Lanche();

					System.out.println("Lanches");
					lanche.escolherPao();
					lanche.escolherRecheio();
					lanche.escolherMolho();
					lanche.confirmaLanche();

					pedido.addItemConsumido(lanche);

					break;

				case 3:
					System.out.println("Salgadinhos - 2 Unidades");

					Salgadinho salgadinho = new Salgadinho();
					salgadinho.escolherMassa();
					salgadinho.escolherRecheio();
					salgadinho.confirmaSalgadinho();

					pedido.addItemConsumido(salgadinho);

					break;

				// Caso finalizar pedido
				case 4:
					int metodoPagamento;

					System.out.println("\n\t *** FINALIZAR PEDIDO ***");
					pedido.mostrarFatura();

					System.out.println("\n\nDeseja Finalizar o pedido? (S/N)");
					String confirmaPedido = scanner.next();

					if (confirmaPedido.equalsIgnoreCase("S")) {
						do {
							System.out.println("\n\t 1 - Cartao \n\t 2 - Dinheiro");
							metodoPagamento = scanner.nextInt();
						} while (metodoPagamento < 1 || metodoPagamento > 2);

						if (metodoPagamento == 1) {
							System.out.println("\n\t ** Pedido Realizado com Sucesso! **");
						}

						// Pedido pago com dinheiro
						else {
							Caixa caixa = new Caixa();

							System.out.println("\n Insira o valor recebido: ");
							caixa.setValorPago((double) scanner.nextInt());
					
							Double troco = caixa.calcularTroco(pedido.calculaPrecoTotal());

							System.out.println("\n\t Troco de R$ " + troco);
							System.out.println("\n\n Pedido Finalizado.");
						}

					} else {
						System.out.println("\nPedido Cancelado!");
						break;
					}

					continuar = false;
					break;

				default:
					System.out.println("Pedido inválido");
					break;
				}

			} catch (Exception e) {
				System.out.println("Pedido Inválido!");
				prato = 0;
			}

		} while (continuar);

	}
}
