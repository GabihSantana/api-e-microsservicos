/**
 * Considere	os	programas	a	seguir,	que	leem	um	código	repetidamente	e	imprimem	o	
	código	lido	até	que	o	código	lido	seja	igual	a	-1.	O	código	-1	não	deve	ser	impresso.		
	a. Qual	das	duas	soluções	é	a	correta?		
	b. Como	a	solução	incorreta	poderia	ser	corrigida?
 */

package lista;

import java.util.Scanner;

public class Exercicio7 {

	public static void main(String[] args) {
		int x = opcaoA();
		
		if(x == 1) {
			System.out.println("Loop A encerrado!");
		}
		
		int y = opcaoB();
		if(y == 1) {
			System.out.println("Loop B encerrado!");
		}
	}
	
	public static Integer opcaoA() {
		Scanner teclado = new Scanner(System.in); 
		int codigo; 
		
		System.out.println("Informe o código A: "); 
		codigo = teclado.nextInt(); 
		
		while (codigo != -1) { 
			System.out.println("Código: " + codigo); 
			System.out.println("Informe o código: "); 
			codigo = teclado.nextInt(); 
		}

		return 1;
	}
	
	public static Integer opcaoB() {
		Scanner teclado = new Scanner(System.in); 
		int codigo; 
		
		do { 
			System.out.print("Informe o código B: "); 
			codigo = teclado.nextInt(); 
			System.out.println("Código: " + codigo); 
		} while (codigo != -1); 
				
		return 1;
	}
	
	// Dentre as duas soluções, a Solução A é correta ao fato de que o Código -1 não deve ser impresso.
	// Acontece que a Solução B realiza o loop e após valida se a condição ainda é verdadeira ou falsa.
	// Do While executa > valida
	// While valida > executa

}
