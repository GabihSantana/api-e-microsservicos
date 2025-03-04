package exercicio21;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorEmprestimos {
	private List<Emprestimo> livrosEmprestimos = new ArrayList<>();

	public GerenciadorEmprestimos() {
		this.livrosEmprestimos = new ArrayList<>();
	}
	
	public void historicoEmprestimo() {
        System.out.println("\n\t ***** Lista de Empréstimos ***** \n");
		for (Emprestimo emprestimos : livrosEmprestimos) {
			System.out.println(emprestimos);
            System.out.println("\n----------------------\n");
		}
	}

	public void adicionarLivro(Emprestimo emprestimos) {
		livrosEmprestimos.add(emprestimos);
		emprestimos.getLivro().setDisponivel(false);
	}
	
}
