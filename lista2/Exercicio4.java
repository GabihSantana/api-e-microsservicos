/**
 * 4 - Leia um número qualquer fornecido pelo usuário. Determine se o número é maior do que 100, imprimindo uma
 mensagem indicando que o "valor é maior que 100" ou uma mensagem indicando que o "valor é menor ou igual a 100". 
 */

package lista2;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		boolean continuarLoop = true;

		do {
			try {
				System.out.println("Insira um número: ");
				numero = teclado.nextInt();
			} catch (Exception e) {
				System.out.println("Digito inválido!");
			}

			if (numero == 50) {
				System.out.println("O valor é 100");
			} else if (numero >= 50) {
				System.out.println("O valor é maior que 100");
			} else {
				System.out.println("O valor é menor que 100");
			}

			System.out.println("Deseja continuar? ");
			String continuar = teclado.next();
			if (continuar.equalsIgnoreCase("s")) {
				continuarLoop = true;
			} else {
				continuarLoop = false;
			}

		} while (continuarLoop);

		teclado.close();
	}
}
