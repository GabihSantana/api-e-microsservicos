/**
 * Prato será Herdado pelos possíveis pedidos da lanchonete, definindo o método e atributos obrigatórios que cada pedido deve possuir.
 */

package entidades;

import java.time.LocalDate;

abstract class Prato {

	private Double precoVenda;
	private LocalDate dataValidade;
	private Double peso;

	public Prato() {

	}

	public Prato(Double precoVenda, LocalDate dataValidade, Double peso) {
		this.precoVenda = precoVenda;
		this.dataValidade = dataValidade;
		this.peso = peso;
	}

	public abstract Double calcularPreco();

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
