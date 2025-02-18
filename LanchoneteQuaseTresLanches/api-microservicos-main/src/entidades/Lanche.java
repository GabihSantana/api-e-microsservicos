package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import enums.LancheMolhoSelecao;
import enums.LanchePaoSelecao;
import enums.LancheRecheioSelecao;

public class Lanche extends Prato {

	private LanchePaoSelecao pao;
	private LancheRecheioSelecao recheio;
	private LancheMolhoSelecao molho;

	public Lanche() {

	}

	public Lanche(LanchePaoSelecao pao, LancheRecheioSelecao recheio, LancheMolhoSelecao molho, Double precoVenda,
			LocalDate dataValidade, Double peso) {
		super(precoVenda, dataValidade, peso);
		this.pao = pao;
		this.recheio = recheio;
		this.molho = molho;
	}

	public LanchePaoSelecao getPao() {
		return pao;
	}

	public void setPao(LanchePaoSelecao paes) {
		this.pao = paes;
	}

	public LancheRecheioSelecao getRecheio() {
		return recheio;
	}

	public void setRecheio(LancheRecheioSelecao lanche) {
		this.recheio = lanche;
	}

	public LancheMolhoSelecao getMolho() {
		return molho;
	}

	public void setMolho(LancheMolhoSelecao molholanche) {
		this.molho = molholanche;
	}
	
	// Metodo responsável pela seleção do pao
	public void escolherPao() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o Pão: ********** \n");
				// enum
				LanchePaoSelecao[] paes = LanchePaoSelecao.values();

				// para cada valor presente no Enum, printa formando um menu ao usuário
				for (int i = 0; i < paes.length; i++) {
					System.out.println((i + 1) + " - " + paes[i].getDescricao());
				}

				int escolha = scanner.nextInt();

				if (escolha < 1 || escolha > paes.length) {
					System.out.println("Pão selecionado inválido!");
				} else {
					setPao(paes[escolha - 1]);
					System.out.println("\t >> Pão: " + pao);
					break;
				}

			} catch (Exception e) {
				System.out.println("Pão selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);

	}

	// Metodo responsavel pela selecao do recheio
	public void escolherRecheio() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o Recheio: ********** \n");
				LancheRecheioSelecao[] lanche = LancheRecheioSelecao.values();

				for (int i = 0; i < lanche.length; i++) {
					System.out.println((i + 1) + " - " + lanche[i].getDescricao());
				}

				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > lanche.length) {
					System.out.println("Recheio selecionado inválido!");
				} else {
					setRecheio(lanche[escolha - 1]);
					System.out.println("\t >> Recheio: " + pao);
					break;
				}

			} catch (Exception e) {
				System.out.println("Recheio selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);

	}

	// Metodo responsavel pela selecao do molho
	public void escolherMolho() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o Molho: ********** \n");
				LancheMolhoSelecao[] Molholanche = LancheMolhoSelecao.values();

				for (int i = 0; i < Molholanche.length; i++) {
					System.out.println((i + 1) + " - " + Molholanche[i].getDescricao());
				}

				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > Molholanche.length) {
					System.out.println("Recheio selecionado inválido!");
				} else {
					setMolho(Molholanche[escolha - 1]);
					System.out.println("\t >> Recheio: " + pao);
					break;
				}

			} catch (Exception e) {
				System.out.println("Recheio selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);
	}

	// metodo responsavel por confirmar o pedido
	public void confirmaLanche() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n ********** Confirme seu Lanche: ********** \n");
		System.out.println("Pão: " + this.pao);
		System.out.println("Recheio: " + this.recheio);
		System.out.println("Molho: " + this.molho);
		System.out.println("O pedido está correto? (S / N)");
		String confirmaPedido = scanner.next();

		if (confirmaPedido.equalsIgnoreCase("s")) {
			try {
				this.setPrecoVenda(calcularPreco());
				this.setDataValidade(LocalDate.now().plusDays(3));
				this.setPeso(0.3);
				System.out.println("Pedido realizado com sucesso!");
			} catch (Exception e) {
				System.out.println("Erro ao confirmar pedido!");
			}
		} else {
			System.out.println("Pedido cancelado!");
		}
	}

	// Método herdado de Prato, calcula preço do prato de acordo com os ingredientes selecionados
	@Override
	public Double calcularPreco() {
		Double precoBaseLanche = 5.00;
		precoBaseLanche += this.pao.getPreco();
		precoBaseLanche += this.molho.getPreco();
		precoBaseLanche += this.recheio.getPreco();

		return precoBaseLanche;
	}

	// Método ToString para retornar o pedido formatado
	@Override
	public String toString() {
		return "LANCHE - \n\t Pão: " + pao + "\n\t Recheio: " + recheio + "\n\t Molho: " + molho + "\n\t Peso: "
				+ getPeso() + "kg" + "\n\t Validade: " + getDataValidade() + "\n\n\t Preço: R$" + getPrecoVenda();
	}

}
