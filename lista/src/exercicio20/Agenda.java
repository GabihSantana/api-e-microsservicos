package exercicio20;

import java.util.ArrayList;
import java.util.List;

import exercicio19.Produto;

public class Agenda {
	
	private List<Contato> contatos;
	private int quantidade;
	
	public Agenda() {
        contatos = new ArrayList<>();
	}
	
	public Agenda(List<Contato> contatos, int quantidade) {
		this.contatos = contatos;
		this.quantidade = quantidade;
	}
	
	public List<Contato> getContatos() {
	    return new ArrayList<>(contatos);
	}

    public void adicionarContato(Contato contato) {
    	contatos.add(contato);
    }

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
