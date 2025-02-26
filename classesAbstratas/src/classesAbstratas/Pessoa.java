package classesAbstratas;

public abstract class Pessoa {
	private String nome;
	private Data nascimento;
	
	
	public Pessoa(String nome, Data nascimento) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
	}

	// metodo abstrato - deve ser implementado pelas subclasses
	public abstract void imprimeDados();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getNascimento() {
		return nascimento;
	}

	public void setNascimento(Data data) {
		nascimento = data;
	}
	
		
}
