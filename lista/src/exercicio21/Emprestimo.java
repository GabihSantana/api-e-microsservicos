package exercicio21;

import java.time.LocalDate;

public class Emprestimo {
	private Livro livro;
	private Pessoa pessoa;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(Livro livro, Pessoa pessoa, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		this.livro = livro;
		this.pessoa = pessoa;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
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
		return "Pessoa: " + pessoa.getNome() + "\nLivro: " + livro.getTitulo() + "\nData Empréstimo: " + dataEmprestimo
				+ "\nData Devolução: " + dataDevolucao;
	}
}
