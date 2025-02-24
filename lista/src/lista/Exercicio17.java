/**
 * Leia	um	número	decimal	(até	3	dígitos)	e	escreva	o	seu	equivalente	em	numeração	
romana.	Utilize	métodos	para	obter	cada	dígito	do	número	decimal	e	para	a	
transformação	de	numeração	decimal	para	romana	(Dica1:	1	=	I,	5	=	V,	10	=	X,	50	=	L,	100	=	
C,	500	=	D,	1.000	=	M;	Dica2:	utilize	um	vetor	guardando	a	tradução	para	cada	um	dos	
dígitos).	
 */

package lista;

import java.util.Scanner;

public class Exercicio17 {

    public static void main(String[] args) {
    	
        int numeroDecimal = lerNumeroDecimal();
   
        int centenas = obterCentenas(numeroDecimal);
        int dezenas = obterDezenas(numeroDecimal);
        int unidades = obterUnidades(numeroDecimal);
        
        String numeroRomano = converterParaRomano(centenas, dezenas, unidades);
        
        escreverResultado(numeroRomano);
    }

    public static int lerNumeroDecimal() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite um número decimal (até 3 dígitos): ");
        int numero = teclado.nextInt();
        
        teclado.close();
        return numero;
    }

    // obter as centenas do número
    public static int obterCentenas(int numero) {
        return numero / 100;
    }

    // obter as dezenas do número
    public static int obterDezenas(int numero) {
        return (numero % 100) / 10;
    }

    // obter as unidades do número
    public static int obterUnidades(int numero) {
        return numero % 10;
    }

    // converter para número romano
    public static String converterParaRomano(int centenas, int dezenas, int unidades) {
    	
        String[] romanosCentenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanosDezenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanosUnidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String numeroRomano = romanosCentenas[centenas] + romanosDezenas[dezenas] + romanosUnidades[unidades];
        
        return numeroRomano;
    }

    // printar o resultado
    public static void escreverResultado(String numeroRomano) {
        System.out.println("O numero inserido em numero romano: " + numeroRomano);
    }

}
