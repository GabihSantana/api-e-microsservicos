package classesAbstratas;

public class Gerente extends Funcionario{

	private String area;
	
	public Gerente(String area, double salario, String nome, Data nascimento) {
		super(salario, nome, nascimento);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public static double calculaImposto() {
		double imposto = 0.0;
		
		return imposto;
	}
	
	@Override
	public void imprimeDados() {

	}	
	
	public String toString() {
	    return "\nGerente - Área: " + area + ", Nome: " + getNome() + ", Salário: " + getSalario() + ", Data de Nascimento: " + getNascimento();
	}
	
}
