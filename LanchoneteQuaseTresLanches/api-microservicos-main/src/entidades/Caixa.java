/**
 * Classe para objetos do tipo Caixa, onde será realizado o calculo do troco
 */

package entidades;

public class Caixa {
	private Double troco;
	private Double valorPago;

	public Caixa() {

	}

	public Caixa(Double troco, Double valorPago) {
		super();
		this.troco = troco;
		this.valorPago = valorPago;
	}

	public Double getTroco() {
		return troco;
	}

	public void setTroco(Double troco) {
		this.troco = troco;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double calcularTroco(Double valorPedido) {
		this.troco = this.valorPago - valorPedido;
		return this.troco;
	}

}
