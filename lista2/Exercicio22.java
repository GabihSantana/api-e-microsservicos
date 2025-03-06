/**
 * 22. Considerando um objeto móvel em movimento uniformemente variado, escreva um programa que receba as seguintes
 informações: um valor real indicando posição inicial do móvel P0, um valor real que corresponde a velocidade do móvel
 V, um outro valor real A correspondente a aceleração do móvel e um número inteiro correspondente ao tempo decorrido
 T. O programa deve calcular a posição final PF do móvel, dado pela relação abaixo:
 PF = P0 + V * T + (A * T2) / 2 
 */
package lista2;

import java.util.Scanner;

public class Exercicio22 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		double P0;
		double V;
		double A;
		double T;
		double PF;
		
		System.out.println("\n Insira a posição inicial: ");
		P0 = teclado.nextDouble();
		
		System.out.println("\n Insira a Velocidade: ");
		V = teclado.nextDouble();
		
		System.out.println("\n Insira a Aceleração: ");
		A = teclado.nextDouble();
		
		System.out.println("\n Insira o Tempo: ");
		T = teclado.nextDouble();
		
		PF = calculaPosicaoFinal(P0, V, A, T);
		
		System.out.println("Posiçao Final: " + PF);
		
		teclado.close();
	}
	
	public static double calculaPosicaoFinal(double P0, double V, double A, double T) {
		double PF;
		
		PF = P0 + (V * T) + (A * Math.pow(T, 2)) / 2;
		
		return PF;
	}

}
