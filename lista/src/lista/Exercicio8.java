/**
 * Calcule	a	série	de	Fibonacci	para	um	número	inteiro	não	negativo	informado	pelo	usuário.	
	A	série	de	Fibonacci	inicia	com	os	números	F0	=	0	e	F1	=	1,	e	cada	número	posterior	
	equivale	à	soma	dos	dois	números	anteriores	(Fn	=	Fn-1	+	Fn-2).	Por	exemplo,	caso	o	usuário	
	informe	o	número	9,	o	resultado	seria:	0,	1,	1,	2,	3,	5,	8,	13,	21,	34.
 */

package lista;

import java.util.Scanner;

public class Exercicio8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
		int numero;
		
		System.out.println("Insira um número inteiro: ");
		numero = teclado.nextInt();
		
		int a = 0;
		int b = 1;
		
		System.out.println(a);
		System.out.println(b);
		
		for(int i = 1; i <= numero; i++) {
			int num = a + b;
			System.out.println(num);
			a = b; // f - 2
			b = num; // f - 1
		}
		
		
		teclado.close();

	}

}
