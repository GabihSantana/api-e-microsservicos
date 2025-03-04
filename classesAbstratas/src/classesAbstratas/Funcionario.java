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

	public double calculaImposto() {
	    return this.salario * 0.03;
	}

	@Override
	public void imprimeDados() {
		System.out.println("Dados do Funcionário: \nNome: " + super.getNome() + ", Salário: " + getSalario() + ", Data de Nascimento: " + super.getNascimento());
	}

	public String toString() {
	    return "\nFuncionario - Nome: " + super.getNome() + ", Salário: " + getSalario() + ", Data de Nascimento: " + super.getNascimento();
	}
	
}
