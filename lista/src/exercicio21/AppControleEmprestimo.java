/**
 * Faça	um	programa	para	controle	de	empréstimo	de	livros,	com	as	classes	Emprestimo,	
Livro	e	Pessoa.	
 */

package exercicio21;

import java.time.LocalDate;

public class AppControleEmprestimo {

	public static void main(String[] args) {
		Livro[] livro = new Livro[3];
		
		livro[0] = new Livro("Dom Casmurro", "Romance", "Machado de Assis", "Editora Garnier", true);
		livro[1] = new Livro("1984", "Ficção Científica", "George Orwell", "Companhia das Letras", true);
		livro[2] = new Livro("O Pequeno Príncipe", "Infantil", "Antoine de Saint-Exupéry", "Agir", true);
		
		Pessoa[] pessoa = new Pessoa[2];
		pessoa[0] = new Pessoa("Ana Souza", 28, "11987654321", "123.456.789-00");
		pessoa[1] = new Pessoa("Carlos Oliveira", 35, "11998765432", "987.654.321-00");
				
		GerenciadorEmprestimos histEmprestimo = new GerenciadorEmprestimos();
		
		LocalDate hoje = LocalDate.now();
		
		Emprestimo[] emprestimo = new Emprestimo[2];

		emprestimo[0] = new Emprestimo(livro[1], pessoa[0], hoje, hoje.plusDays(7));
		histEmprestimo.adicionarLivro(emprestimo[0]);
		
		emprestimo[1] = new Emprestimo(livro[2], pessoa[1], hoje, hoje.plusDays(7));
		histEmprestimo.adicionarLivro(emprestimo[1]);
		
		histEmprestimo.historicoEmprestimo();
		
		// System.out.println(livro[1]);
	}

}
