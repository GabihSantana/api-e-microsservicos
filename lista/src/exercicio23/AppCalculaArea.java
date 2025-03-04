/**
 * 23. Faça	um	programa	que	calcule	a	área	de	uma	figura	geométrica.	Aceite	quatro	tipos	de	
figura	geométrica:	quadrado,	retângulo,	triângulo	e	círculo.	Use	herança	e	polimorfismo.	
 */

package exercicio23;

public class AppCalculaArea {

	public static void main(String[] args) {
		FiguraGeometrica quadrado = new Quadrado(5);
		FiguraGeometrica retangulo = new Retangulo(4, 6);
		FiguraGeometrica triangulo = new Triangulo(3, 8);
		FiguraGeometrica circulo = new Circulo(7);

		System.out.println("Área do Quadrado: " + quadrado.calcularArea());
		System.out.println("Área do Retângulo: " + retangulo.calcularArea());
		System.out.println("Área do Triângulo: " + triangulo.calcularArea());
		System.out.println("Área do Círculo: " + circulo.calcularArea());

	}

}
