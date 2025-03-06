/**
 * 19. Escreva um programa que leia um número real entre 0.00 e 100.00 e o exiba por extenso como se fosse uma quantia em
 dinheiro, por exemplo: 1.00 -> "um real", .12.73 -> "doze reais e setenta e três centavos". 
 */
package lista2;

import java.util.Scanner;

public class Exercicio19 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		double numero;
		String resultado;
		
		do {
			System.out.println("\n Insira um numero real entre 0.00 e 100.00: ");
			numero = teclado.nextDouble();
		}while(numero > 100.00 || numero < 0.00);
		
		resultado = numeroPorExtenso(numero);

        System.out.println(resultado + " real");

		
		teclado.close();
	}
	
    public static String numeroPorExtenso(double numero) {
        if (numero == 0) {
            return "zero";
        }
        
        String[] unidades = {"", "um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        String[] dezenas = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
        String[] onzeDezenove = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] centenas = {"", "cem"};
        
        String resultado = "";
        
        // Pegando os numeros
        double centena = numero / 100;
        numero %= 100;
        
        double dezena = numero / 10;
        
        double unidade = numero % 10;

        
        if (centena > 0) {
            resultado += centenas[(int)centena] + " ";
        }
        
        if(dezena == 1) {
        	resultado += onzeDezenove[(int)unidade];
        }
        
        if (dezena > 1) {
            resultado += dezenas[(int)dezena] + " ";
            resultado += unidades[(int)unidade];
        } 
        
        else if (unidade > 0) {
            resultado += unidades[(int)unidade];
        }

        return resultado;

    }
	

}
