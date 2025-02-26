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
		
	}
	
	public String toString() {
	    return "\nCliente - Código: " + codigo + ", Nome: " + getNome() + ", Data de Nascimento:" + getNascimento();
	}
	
}
