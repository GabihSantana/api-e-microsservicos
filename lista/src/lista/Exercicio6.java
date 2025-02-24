/**
 * Determine	o	número	de	dígitos	de	um	número	informado.	
 */

package lista;

import java.util.Scanner;

public class Exercicio6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
	        
	    System.out.print("Digite um número inteiro: ");
	    int numero = teclado.nextInt();
	        
	    // transforma para string
	    int numeroDigitos = String.valueOf(numero).length();
	        
	    System.out.println("O número de dígitos do numero é: " + numeroDigitos);
	        
	      teclado.close();
	    }
}
