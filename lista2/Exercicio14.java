/**
 * 14. Escreva um programa que leia 3 notas (valores reais), calculando e exibindo sua média aritmética. Imprima também
 "Aprovado" se a média for maior que 7, "Reprovado" se for menor que 3 e "Exame" se estiver entre 3 e 7. 
 */
package lista2;

import java.util.Scanner;

public class Exercicio14 {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		double nota1 = 0;
		double nota2 = 0;
		double nota3 = 0;
		double situacao = 0;

		System.out.println("\n Informe a nota 1 do aluno: ");
		nota1 = teclado.nextFloat();

		System.out.println("\n Informe a nota 2 do aluno: ");
		nota2 = teclado.nextFloat();
		
		System.out.println("\n Informe a nota 3 do aluno: ");
		nota3 = teclado.nextFloat();

		situacao = media(nota1, nota2, nota3);

		if (situacao > 7) {
			System.out.println("Aprovado!");
		} else if (situacao >= 3 && situacao <= 7) {
			System.out.println("Exame!");
		} else {
			System.out.println("Reprovado!");
		}

		teclado.close();

	}

	public static double media(double nota1, double nota2, double nota3) {

		double media = (nota1 + nota2 + nota3) / 3;

		return media;
	}
}
