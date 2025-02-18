/**
 * Classe Pizza: Responsavel por permitir a montagem da pizza de acordo com a necessidade do usuario. Segue a mesma lógica que Lanche e Salgadinho.
 */
package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import enums.PizzaBordaSelecao;
import enums.PizzaRecheioSelecao;
import enums.PizzaMolhoSelecao;

public class Pizza extends Prato {

	private PizzaMolhoSelecao molho;
	private PizzaRecheioSelecao recheio;
	private PizzaBordaSelecao borda;

	public Pizza() {
	}

	public Pizza(PizzaMolhoSelecao molho, PizzaRecheioSelecao recheio, PizzaBordaSelecao borda, Double precoVenda,
			LocalDate dataValidade, Double peso) {
		super(precoVenda, dataValidade, peso);
		this.molho = molho;
		this.recheio = recheio;
		this.borda = borda;
	}

	public PizzaMolhoSelecao getMolho() {
		return molho;
	}

	public void setMolho(PizzaMolhoSelecao molho) {
		this.molho = molho;
	}

	public PizzaRecheioSelecao getRecheio() {
		return recheio;
	}

	public void setRecheio(PizzaRecheioSelecao recheio) {
		this.recheio = recheio;
	}

	public PizzaBordaSelecao getBorda() {
		return borda;
	}

	public void setBorda(PizzaBordaSelecao borda) {
		this.borda = borda;
	}

	public void escolherMolho() {

		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o molho: ********** \n");
				PizzaMolhoSelecao[] molhos = PizzaMolhoSelecao.values();

				for (int i = 0; i < molhos.length; i++) {
					System.out.println((i + 1) + " - " + molhos[i].getDescricao());
				}

				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > molhos.length) {
					System.out.println("Molho selecionado inválido!");
				} else {
					setMolho(molhos[escolha - 1]);
					System.out.println("\t >> Molho: " + molho);
					break;
				}
			} catch (Exception e) {
				System.out.println("Molho selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);
	}

	public void escolherRecheio() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o Recheio: ********** \n");
				PizzaRecheioSelecao[] recheios = PizzaRecheioSelecao.values();

				for (int i = 0; i < recheios.length; i++) {
					System.out.println((i + 1) + " - " + recheios[i].getDescricao());
				}
				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > recheios.length) {
					System.out.println("Recheio selecionado inválido!");
				} else {
					setRecheio(recheios[escolha - 1]);
					System.out.println("\t >> Recheio: " + recheio);
					break;
				}
			} catch (Exception e) {
				System.out.println("Recheio selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);
	}

	public void escolherBorda() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha a Borda: ********** \n");
				PizzaBordaSelecao[] bordas = PizzaBordaSelecao.values();

				for (int i = 0; i < bordas.length; i++) {
					System.out.println((i + 1) + " - " + bordas[i].getDescricao());
				}
				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > bordas.length) {
					System.out.println("Borda selecionada inválida!");
				} else {
					setBorda(bordas[escolha - 1]);
					System.out.println("\t >> Borda: " + borda);
					break;
				}
			} catch (Exception e) {
				System.out.println("Borda selecionada inválida!");
				scanner.nextLine();
			}

		} while (true);
	}

	public void confirmaPizza() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n ********** Confirme seu pedido de Pizza: ********** \n");
		System.out.println("Molho: " + this.molho);
		System.out.println("Recheio: " + this.recheio);
		System.out.println("Borda: " + this.borda);
		System.out.println("O pedido está correto? (S / N)");
		String confirmaPedido = scanner.next();

		if (confirmaPedido.equalsIgnoreCase("s")) {
			try {
				this.setPrecoVenda(calcularPreco());
				this.setDataValidade(LocalDate.now().plusDays(2));
				this.setPeso(0.7);

				System.out.println("Pedido realizado com sucesso!");
			} catch (Exception e) {
				System.out.println("Erro ao confirmar pedido!");
			}
		} else {
			System.out.println("Pedido cancelado!");
		}

	}

	@Override
	public Double calcularPreco() {
		double precoBasePizza = 25;

		precoBasePizza += this.borda.getPreco();
		precoBasePizza += this.recheio.getPreco();
		precoBasePizza += this.molho.getPreco();

		return precoBasePizza;
	}

	@Override
	public String toString() {
		return "PIZZA - \n\t Molho: " + molho + "\n\t Recheio: " + recheio + "\n\t Borda: " + borda + "\n\t Peso: "
				+ getPeso() + "kg" + "\n\t Validade: " + getDataValidade() + "\n\n\t Preço: R$" + getPrecoVenda();
	}

}
