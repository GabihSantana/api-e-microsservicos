package classesAbstratas;

public class Cliente extends Pessoa {
	private int codigo;

	public Cliente(int codigo, String nome, Data nascimento) {
		super(nome, nascimento);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public void imprimeDados() {
		System.out.println("Dados do Cliente: \nCódigo: " + getCodigo() + ", Nome: " + super.getNome() + ", Data de Nascimento: "
				+ super.getNascimento());
	}

	@Override
	public String toString() {
		return "\nCliente - Código: " + getCodigo() + ", Nome: " + super.getNome() + ", Data de Nascimento: " + super.getNascimento();
	}

}
