package classesAbstratas;

public class Gerente extends Funcionario {

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

	public double calculaImposto() {
		return getSalario() * 0.05;
	}

	@Override
	public void imprimeDados() {
		System.out.println("Dados do Gerente: \nÁrea: " + getArea() + ", Nome: " + super.getNome() + ", Salário: " + super.getSalario()
				+ ", Data de Nascimento: " + super.getNascimento());
	}
	
	@Override
	public String toString() {
		return "\nGerente - Área: " + getArea() + ", Nome: " + super.getNome() + ", Salário: " + super.getSalario()
				+ ", Data de Nascimento: " + super.getNascimento();
	}

}
