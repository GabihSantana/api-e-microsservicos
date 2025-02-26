package classesAbstratas;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
	private int qtdAtual;
	private static List<Pessoa> pessoas = new ArrayList<>();
	
	public CadastroPessoas(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}

	public List<Pessoa> getPessoa() {
		return new ArrayList<>(pessoas);
	}
	
	public static void cadastraPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public static void imprimeCadastro() {
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

	public int getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}
	
}
