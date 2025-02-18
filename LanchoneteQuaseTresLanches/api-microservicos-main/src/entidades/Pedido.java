package entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private String nomeCliente;
	private Double taxaServico;
	private List<Prato> itensConsumidos = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(String nomeCliente, Double taxaServico) {
		this.nomeCliente = nomeCliente;
		this.taxaServico = taxaServico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public void addItemConsumido(Prato prato) {
		itensConsumidos.add(prato);
	}

	public List<Prato> getItensConsumidos() {
		return itensConsumidos;
	}

	// A cada prato, a taxa soma 10% em cima do valor do pedido
	public Double calculaTaxaServico() {
		Double taxa = 0.00;

		for (Prato prato : itensConsumidos) {
			taxa += prato.getPrecoVenda() * 0.1;
		}

		setTaxaServico(taxa);
		return taxa;
	}

	// Responsável por realizar o calculo do preço total dos pedidos feito
	public Double calculaPrecoTotal() {
		Double total = 0.0;

		for (Prato prato : itensConsumidos) {
			total += prato.getPrecoVenda();
		}
		return total + getTaxaServico();
	}

	// Metodo responsavel por mostrar a fatura
	public void mostrarFatura() {
		System.out.println(" ========================== FATURA ========================== ");
		System.out.println("Cliente: " + getNomeCliente());
		System.out.println("Taxa de Serviço: " + calculaTaxaServico());
		for (Prato prato : itensConsumidos) {
			System.out.println(".");
			System.out.println(prato);
		}
		System.out.println("\n\t >>>>> TOTAL A PAGAR: " + calculaPrecoTotal());
	}

}
