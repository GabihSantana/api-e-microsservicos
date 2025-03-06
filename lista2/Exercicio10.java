/**
 * 10. Leia três números quaisquer, imprimindo-os em ordem crescente. 
 */
package lista2;

import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int[] numeros = new int[3];
		int aux;
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Insira um número: ");
			numeros[i] = teclado.nextInt();
		}
		
		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < numeros.length - 1; j++) {
				if(numeros[j] > numeros[j + 1]) {
    				aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
				}
			}
		}
		
		System.out.println("Numeros Ordenados: ");
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(" "+ numeros[i]);
		}
				
		teclado.close();
	}
}
