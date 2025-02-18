package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import enums.SalgadoMassaSelecao;
import enums.SalgadoRecheioSelecao;

public class Salgadinho extends Prato {

	private SalgadoRecheioSelecao recheio;
	private SalgadoMassaSelecao massa;

	public Salgadinho() {
	}

	public Salgadinho(SalgadoRecheioSelecao recheio, SalgadoMassaSelecao massa, Double precoVenda,
			LocalDate dataValidade, Double peso) {
		super(precoVenda, dataValidade, peso);
		this.recheio = recheio;
		this.massa = massa;
	}

	public SalgadoRecheioSelecao getRecheio() {
		return recheio;
	}

	public void setRecheio(SalgadoRecheioSelecao recheios) {
		this.recheio = recheios;
	}

	public SalgadoMassaSelecao getMassa() {
		return massa;
	}

	public void setMassa(SalgadoMassaSelecao massa2) {
		this.massa = massa2;
	}

	public void escolherMassa() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha a Massa: ********** \n");
				SalgadoMassaSelecao[] massa = SalgadoMassaSelecao.values();

				for (int i = 0; i < massa.length; i++) {
					System.out.println((i + 1) + " - " + massa[i].getDescricao());
				}
				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > massa.length) {
					System.out.println("Recheio selecionado inválido!");
				} else {
					setMassa(massa[escolha - 1]);
					System.out.println("\t >> Massa: " + massa);
					break;
				}
			} catch (Exception e) {
				System.out.println("Massa selecionada inválida!");
				scanner.nextLine();
			}

		} while (true);
	}

	public void escolherRecheio() {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("\n ********** Escolha o Recheio: ********** \n");
				SalgadoRecheioSelecao[] recheios = SalgadoRecheioSelecao.values();

				for (int i = 0; i < recheios.length; i++) {
					System.out.println((i + 1) + " - " + recheios[i].getDescricao());
				}
				Integer escolha = scanner.nextInt();

				if (escolha < 1 || escolha > recheios.length) {
					System.out.println("Recheio selecionado inválido!");
				} else {
					setRecheio(recheios[escolha - 1]);
					System.out.println("\t >> Recheio: " + recheios);
					break;
				}
			} catch (Exception e) {
				System.out.println("Recheio selecionado inválido!");
				scanner.nextLine();
			}

		} while (true);
	}

	public void confirmaSalgadinho() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n ********** Confirme seu pedido de Salgadinho: ********** \n");
		System.out.println("Massa: " + this.massa);
		System.out.println("Recheio: " + this.recheio);
		System.out.println("O pedido está correto? (S / N)");
		String confirmaPedido = scanner.next();

		if (confirmaPedido.equalsIgnoreCase("s")) {
			try {
				this.setPrecoVenda(calcularPreco());
				this.setDataValidade(LocalDate.now().plusDays(3));
				this.setPeso(0.2);
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
		Double precoBaseSalgados = 3.00;
		precoBaseSalgados += this.recheio.getPreco();
		precoBaseSalgados += this.massa.getPreco();

		return precoBaseSalgados;
	}

	@Override
	public String toString() {
		return "SALGADINHO - \n\t Massa: " + massa + "\n\t Recheio: " + recheio + "\n\t Peso: " + getPeso() + "kg"
				+ "\n\t Validade: " + getDataValidade() + "\n\n\t Preço: R$" + getPrecoVenda();
	}
}
