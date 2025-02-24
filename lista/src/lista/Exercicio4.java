/**
 * Para	cada	produto	informado	(nome,	preço	e	quantidade),	escreva	o	nome	do	produto	
comprado	e	o	valor	total	a	ser	pago,	considerando	que	são	oferecidos	descontos	pelo	
número	de	unidades	compradas,	segundo	a	tabela	abaixo:		

	a. Até	10	unidades:	valor	total	
	b. de	11	a	20	unidades:	10%	de	desconto	
	c. de	21	a	50	unidades:	20%	de	desconto	
	d. acima	de	50	unidades:	25%	de	desconto
 */
package lista;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		String nomeProduto;
		double valor;
		double valorPagamento;
		Integer quantidade;

		System.out.println("Insira o nome do produto comprado: ");
		nomeProduto = teclado.next();

		System.out.println("Insira o valor do produto: ");
		valor = teclado.nextFloat();

		System.out.println("Insira a quantidade: ");
		quantidade = teclado.nextInt();

		if (quantidade <= 10) {
			valorPagamento = valor * quantidade;
		} else if (quantidade >= 11 && quantidade <= 20) {
			valorPagamento = (valor * quantidade) * 0.9;
		} else if (quantidade >= 21 && quantidade <= 50) {
			valorPagamento = (valor * quantidade) * 0.8;
		} else {
			valorPagamento = (valor * quantidade) * 0.75;
		}

		System.out.println("\n\t ***** PRODUTO COMPRADO: ***** \n Nome: " + nomeProduto + "\n Preço: " + valor
				+ "\n Quantidade: " + quantidade + "\n\t VALOR A SER PAGO: " + valorPagamento);
		
		teclado.close();
	}

}
