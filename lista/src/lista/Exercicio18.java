/**
 *  Escreva	um	número	por	extenso	aceitando	números	de	até	9	dígitos,	usando	métodos	para	
	as	traduções	e	vetores	de	Strings	que	guardam	cada	tradução	(ex.:	unidades	=	{	“zero”,	
	“um”,	“dois”,	...,	“nove”	}).	
 */

package lista;

import java.util.Scanner;

public class Exercicio18 {


    public static void main(String[] args) {
    	
        long numero = numero();
        String numeroPorExtenso = numeroPorExtenso(numero);
        
        mostrarResultado(numeroPorExtenso);
    }

    public static long numero() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite um número (até 9 dígitos): ");
        long num = teclado.nextLong();
        
        teclado.close();
        return num;
    }

    public static String numeroPorExtenso(long numero) {
        if (numero == 0) {
            return "zero";
        }
        
        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        String[] dezenas = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
        String[] especiaisDezAVinte = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] centenas = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
        
        String resultado = "";
        
        // dividindo o número 
        long bilhao = numero / 1000000000;
        numero %= 1000000000;
        
        long milhao = numero / 1000000;
        numero %= 1000000;
        
        long mil = numero / 1000;
        numero %= 1000;
        
        long centena = numero / 100;
        numero %= 100;
        
        long dezena = numero / 10;
        
        long unidade = numero % 10;
        
        
        if (bilhao > 0) {
            resultado += unidades[(int)bilhao] + " bilhão ";
        }
        
        if (milhao > 0) {
            resultado += unidades[(int)milhao] + " milhão ";
        }
        
        if (mil > 0) {
            resultado += unidades[(int)mil] + " mil ";
        }
        
        if (centena > 0) {
            resultado += centenas[(int)centena] + " ";
        }
        
        if (dezena > 1) {
            resultado += dezenas[(int)dezena] + " ";
            resultado += unidades[(int)unidade];
        } 
        
        // 11 - 19
        else if (dezena == 1) {
            resultado += especiaisDezAVinte[(int)unidade];
        } 
        
        else if (unidade > 0) {
            resultado += unidades[(int)unidade];
        }
        
        return resultado;
    }

    public static void mostrarResultado(String numeroPorExtenso) {
        System.out.println("Número " + numeroPorExtenso);
    }

}
