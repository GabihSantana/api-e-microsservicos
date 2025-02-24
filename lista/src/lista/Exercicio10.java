/**
 * Calcule	o	retorno	de	um	investimento	financeiro	fazendo	as	contas	mês	a	mês,	sem	usar	a	
fórmula	de	juros	compostos.	O	usuário	deve	informar	quanto	será	investido	por	mês	e	
qual	será	a	taxa	de	juros	mensal.	O	programa	deve	informar	o	saldo	do	investimento	após	
um	ano	(soma	das	aplicações	mês	a	mês	considerando	os	juros	compostos),	e	perguntar	ao	
usuário	se	ele	deseja	que	seja	calculado	o	ano	seguinte,	sucessivamente.
 */

package lista;

import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
		
		double valorInvestimento = 0;
		double taxaJurosMensal = 0;
		double saldoAposUmAno = 0;
		String verMais;
		
		System.out.println("\n Informe quanto será investido por mes: ");
		valorInvestimento = teclado.nextFloat();
		
		System.out.println("\n Informe quanto será a taxa de juros mensal: ");
		taxaJurosMensal = teclado.nextFloat();
		
		saldoAposUmAno = valorInvestimento * (taxaJurosMensal / 100);
		
		do {
			for (int i = 0; i < 12; i++) {
	               saldoAposUmAno += valorInvestimento; 
	               saldoAposUmAno += saldoAposUmAno * (taxaJurosMensal / 100);  // calcula o juros
	           }
			
			System.out.println("Saldo do investimento após 1 ano: " + saldoAposUmAno);
			System.out.println("Deseja processar mais um ano? (S/N)");
			verMais = teclado.next();
		}while(verMais.equalsIgnoreCase("s"));
		
		System.out.println("Calculo encerrado");
		

		teclado.close();
		
	}

}
