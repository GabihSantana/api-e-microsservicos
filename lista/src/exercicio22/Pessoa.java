package exercicio22;

public class Pessoa {
	private String nome;
    private int idade;
    private Pessoa pai;
    private Pessoa mae;
    
    public Pessoa() {
    	
    }
       
	public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.pai = pai;
		this.mae = mae;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Pessoa getPai() {
		return pai;
	}
	public void setPai(Pessoa pai) {
		this.pai = pai;
	}
	public Pessoa getMae() {
		return mae;
	}
	public void setMae(Pessoa mae) {
		this.mae = mae;
	}
	
	public void mostrarArvoreGenealogica() {
		System.out.print(" ****** Arvore Genealogica ****** ");
        System.out.println("\nNome: " + nome + "\nIdade: " + idade);
        System.out.println("Pai: " + (pai != null ? pai.getNome() : "Desconhecido"));
        System.out.println("Mãe: " + (mae != null ? mae.getNome() : "Desconhecida"));
    }

}
