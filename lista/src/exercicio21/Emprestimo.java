package exercicio21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exercicio20.Contato;

public class Emprestimo {
	private Livro livro;
	private Pessoa pessoa;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private List<Livro> livrosEmprestimos = new ArrayList<>();

	public Emprestimo() {
	}

	public Emprestimo(Livro livro, Pessoa pessoa, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.livro = livro;
		this.pessoa = pessoa;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public List<Livro> getLivroEmprestados() {
		return new ArrayList<>(livrosEmprestimos);
	}

	public void adicionarLivro(Livro livro) {
		livrosEmprestimos.add(livro);
		livro.setDisponivel(false);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "\n Empréstimo do livro " + livro.getTitulo() + " para " + pessoa.getNome() + " | Data de Empréstimo: "
				+ dataEmprestimo + " | Data de Devolução: "
				+ dataDevolucao;
	}

}
