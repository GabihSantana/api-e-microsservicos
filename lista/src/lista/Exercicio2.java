/**
 * Calcule	a	distância	entre	dois	pontos	num	espaço	de	3	dimensões
 */

package lista;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		Double x1, y1, x2, y2, z1, z2, distancia;
		// x1 = 0.0; x2 = -2.0; y1 = 2.0; y2 = 0.0; z1 = 2.0; z2 = 1.0;

		Scanner teclado = new Scanner(System.in);
		try {
			System.out.println("Digite o valor de X1: ");
			x1 = teclado.nextDouble();

			System.out.println("Digite o valor de Y1: ");
			y1 = teclado.nextDouble();

			System.out.println("Digite o valor de X2: ");
			x2 = teclado.nextDouble();

			System.out.println("Digite o valor de Y2: ");
			y2 = teclado.nextDouble();

			System.out.println("Digite o valor de Z1: ");
			z1 = teclado.nextDouble();

			System.out.println("Digite o valor de Z2: ");
			z2 = teclado.nextDouble();

			distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));

			System.out.println(distancia);

		} catch (Exception e) {
			System.out.println("Erro - Inserção inválida! " + e);
		}

		teclado.close();

	}

}
