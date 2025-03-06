/**
 * 20. Escreva um programa  que leia um valor real correspondente a uma medida em metros, convertendo o valor dado em pés
 (1 metro = 3.315 pés), exibindo  os valores dado e convertido. Caso o usuário forneça um valor negativo, deve ser exibida
 uma mensagem e a operação de conversão não deve ser efetuada. 
 */
package lista2;

import java.util.Scanner;

public class Exercicio20 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		double metro = 0;
		double pes = 0;

		try {
			System.out.println("Insira o valor em metros: ");
			metro = teclado.nextDouble();

			if (metro < 0) {
				System.out.println("Não é aceito valor de metros negativo!");
			}

		} catch (Exception e) {
			System.out.println("Valor inválido!");
		}
		
		pes = metrosParaPes(metro);
		
		System.out.println("Metros: " + metro);
		System.out.println("Pés: " + pes);

		teclado.close();

	}
	
	public static double metrosParaPes(double metro) {
		double pes = 3.315;
			
		return metro * pes;
	}

}
