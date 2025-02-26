package classesAbstratas;

public class Funcionario extends Pessoa {
	private double salario;

	public Funcionario(double salario, String nome, Data nascimento) {
		super(nome, nascimento);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static double calculaImposto() {
		double imposto = 0.0;

		return imposto;
	}

	@Override
	public void imprimeDados() {

	}

	public String toString() {
	    return "\nFuncionario - Nome: " + getNome() + ", Salário: " + salario + ", Data de Nascimento: " + getNascimento();
	}
	
}
