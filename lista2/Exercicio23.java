/**
 * 23. Escreva um programa que receba as seguintes informações: um valor real indicando capital inicial PV, um valor real que
 corresponde a taxa de juros da aplicação J e um número inteiro de períodos da aplicação N. O programa deve retornar o
 capital futuro FV dado pela relação abaixo:
 FV = PV * ( 1 + J )N
 */
package lista2;

import java.util.Scanner;

public class Exercicio23 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double PV;
		double J;
		int N;
		double FV;
		
		System.out.println("\n Insira o capital inicial: ");
		PV = teclado.nextDouble();
		
		System.out.println("\n Insira a taxa de juros (%): ");
		J = teclado.nextDouble();
		
		System.out.println("\n Insira o período da aplicação: ");
		N = teclado.nextInt();
		
		FV = calculaCapitalFuturo(PV, J, N);
		System.out.println(String.format("\n Capital Futuro: R$ %.2f", FV));
				
		teclado.close();
		
	}
	public static double calculaCapitalFuturo(double pv, double j, double n) {
		double FV = 0;
		
		FV = pv * Math.pow((1 + (j / 100)), n);
		
		return FV;
	}

}
