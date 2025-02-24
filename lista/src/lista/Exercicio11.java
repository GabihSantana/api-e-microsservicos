/**
 * 11. Calcule	a	raiz	quadrada	aproximada	de	um	número	inteiro	informado	pelo	usuário,	
respeitando	o	erro	máximo	também	informado	pelo	usuário.	Não	utilize	funções	
predefinidas.	
 */

package lista;

import java.util.Scanner;

public class Exercicio11 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 

		int numInteiro;
		int erroMaximo;
		double raizQuadrada;
		
		System.out.println("\n Informe o numero inteiro para calculo da raiz quadrada: ");
		numInteiro = teclado.nextInt();
		
		System.out.println("\n Informe o erro máximo: ");
		erroMaximo = teclado.nextInt();
		
		
		raizQuadrada = numInteiro * (1.0 / 2);

	    while (raizQuadrada * raizQuadrada - numInteiro > erroMaximo) {
	         raizQuadrada = (raizQuadrada + numInteiro / raizQuadrada) / 2;
	    }
		
		System.out.println("\n A raiz quadrada aproximada do numero informado é: " + (int)(raizQuadrada));
		System.out.println(Math.sqrt(numInteiro));
		
		teclado.close();

	}

}
