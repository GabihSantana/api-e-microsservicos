package classesAbstratas;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
	private int qtdAtual;
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public CadastroPessoas() {
	}

	public List<Pessoa> getPessoa() {
		return new ArrayList<>(pessoas);
	}
	
	public void cadastraPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public void imprimeCadastro() {
		System.out.println("Quantidade de Cadastros: " + getQtdAtual());
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

	public int getQtdAtual() {
		try {
			qtdAtual = pessoas.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtdAtual;
	}

}
