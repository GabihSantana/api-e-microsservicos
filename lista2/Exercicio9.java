/**
 * Leia três números reais fornecidos pelo usuário. Descubra qual deles é o menor de todos, imprimindo seu valor.
 */
package lista2;

import java.util.Scanner;

public class Exercicio9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int[] numeros = new int[3];
		int menorNumero = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Insira um número: ");
			numeros[i] = teclado.nextInt();
		}
		
		menorNumero = numeros[0];

		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] < menorNumero) {
				menorNumero = numeros[i];
			}
		}
		
		System.out.println("O menor numero inserido foi: " + menorNumero);
		
		teclado.close();
		
	}

}
