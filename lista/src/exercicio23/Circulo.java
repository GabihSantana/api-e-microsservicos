package exercicio23;

public class Circulo extends FiguraGeometrica {
	
	private double raio;
	private double pi = 3.14;
	
	public Circulo(double raio) {
		super();
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public double calcularArea() {
		return pi * Math.pow(raio, 2);
	}
		
}
