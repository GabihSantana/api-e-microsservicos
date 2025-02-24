/**
 * Construa	a	tabela	de	multiplicação	de	números	de	1	a	10	(ex.:	1	x	1	=	1,	1	x	2	=	2,	etc.).
 */

package lista;

public class Exercicio5 {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Tabuada do " + i);
			for(int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + i * j);
			}
		}
	}

}
