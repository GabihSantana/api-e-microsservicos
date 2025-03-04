/**
 * Determine	as	raízes	de	uma	equação	de	2º	grau
 */

package lista;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		Double a, b, c, delta;
		Double[] raiz;
		
		//Double a = 2.0; Double b = 7.0; Double c = 5.0; Double delta; 
		try {
			System.out.println("Digite o valor de A: ");
			a = teclado.nextDouble();

			System.out.println("Digite o valor de B: ");
			b = teclado.nextDouble();

			System.out.println("Digite o valor de C: ");
			c = teclado.nextDouble();
			
			delta = calcularDelta(a, b, c);
			
			raiz = calcularRaiz(b, delta, a);
			
			System.out.println(Arrays.toString(raiz));


		} catch (Exception e) {
			System.out.println("Erro - Inserção inválida! " + e);
		}
		
		teclado.close();
	}
	
	public static Double calcularDelta(double a, double b, double c){
		
		Double delta;
		
		delta = ((Math.pow(b, 2)) - (4*a*c));
		
		// System.out.println(delta);
		
		return delta;
	}
	
	public static Double[] calcularRaiz(double b, double delta, double a) {
		
		Double[] raizes = new Double[2];
		
		raizes[0] = ((-1 * b - Math.sqrt(delta)) / (2*a));
		raizes[1] = ((-1 * b + Math.sqrt(delta)) / (2*a));
		
		return raizes;
	}

}
