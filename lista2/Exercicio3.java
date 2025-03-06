/**
 * 3. Leia um número qualquer fornecido pelo usuário. Determine se o número é maior do que 50, imprimindo uma mensagem
 indicando tal fato. 
 */

package lista2;

import java.util.Scanner;

public class Exercicio3 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		boolean continuarLoop = true;
		
		do {
			try {
				System.out.println("Insira um número: ");
				numero = teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Digito inválido!");
			}
			
			if (numero == 50) {
				System.out.println("O número é 50");
			}
			else if (numero >= 50) {
				System.out.println("O número é maior que 50");
			}
			else {
				System.out.println("O número é menor que 50");
			}
			
			System.out.println("Deseja continuar? ");
			String continuar = teclado.next();
			if (continuar.equalsIgnoreCase("s")) {
				continuarLoop = true;
			}else {
				continuarLoop = false;
			}
			
		}while(continuarLoop);
		
		teclado.close();
	}
	

	
}
