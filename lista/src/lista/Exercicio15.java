/**
 * Faça	um	método	que	calcule	a	média	de	um	aluno	de	acordo	com	o	critério	definido	neste	
curso.	Além	disso,	faça	um	outro	método	que	informe	o	status	do	aluno	de	acordo	com	a	
tabela	a	seguir:	
Nota	acima	de	6	à	“Aprovado”	
Nota	entre	4	e	6	à	Conceito	“Verificação	Suplementar”	
Nota	abaixo	de	4	à	Conceito	“Reprovado”
 */

package lista;

import java.util.Scanner;

public class Exercicio15 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
		
		double notaTrabalho = 0;
		double notaAvaliacao = 0;
		double situacao = 0;
		
		System.out.println("\n Informe a nota do trabalho do aluno: ");
		notaTrabalho = teclado.nextFloat();
		
		System.out.println("\n Informe a nota da prova do aluno: ");
		notaAvaliacao = teclado.nextFloat();
		
		situacao = media(notaTrabalho, notaAvaliacao);
		
		if (situacao > 6) {
			System.out.println("APROVADO!");
		}
		else if (situacao >= 4 && situacao <= 6) {
			System.out.println("Conceito Verificação Suplementar!");
		}
		else {
			System.out.println("Conceito Reprovado!");
		}
		
		teclado.close();
		
	}
	
	public static double media(double notaTrabalho, double notaAvaliacao) {
		
		double media = (notaTrabalho + notaAvaliacao) / 2;
		
		return media;
	}

}
