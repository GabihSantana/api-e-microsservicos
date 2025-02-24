/**
 * Calcule	a	distância	entre	dois	pontos	num	espaço	de	3	dimensões
 */

package lista;

public class Exercicio2 {

	public static void main(String[] args) {
		 Double x1, y1, x2, y2, z1, z2, distancia;
		 
		 x1 = 0.0;
		 x2 = -2.0;
		 y1 = 2.0;
		 y2 = 0.0;
		 z1 = 2.0;
		 z2 = 1.0;
		 
		 
		 distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));
		 
		 System.out.println(distancia);
		 
	}

}
