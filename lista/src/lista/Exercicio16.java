/**
 * Leia	do	usuário	o	tempo	em	segundos	e	escreva	em	horas,	minutos	e	segundos.	Utilize	
cinco	métodos,	para	a	leitura	e	escrita	de	dados	e	para	obtenção	de	horas,	minutos	e	
segundos	a	partir	do	tempo	em	segundos.		
 */

package lista;

import java.util.Scanner;

public class Exercicio16 {

	public static void main(String[] args) {
        int segundosUsuario = lerTempo(); 
        int horas = calcularHoras(segundosUsuario); 
        int minutos = calcularMinutos(segundosUsuario); 
        int segundos = calcularSegundos(segundosUsuario); 

        escreverResultado(horas, minutos, segundos);
    }

    // pegar o tempo em segundos
    public static int lerTempo() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\n Informe o tempo em segundos: ");
        int tempo = teclado.nextInt();
        
        teclado.close();
        return tempo;
    }

    // calcular horas
    public static int calcularHoras(int tempoEmSegundos) {
        return tempoEmSegundos / 3600;
    }

    // calcular minutos
    public static int calcularMinutos(int tempoEmSegundos) {
        return (tempoEmSegundos % 3600) / 60;
    }

    // calcular segundos
    public static int calcularSegundos(int tempoEmSegundos) {
        return tempoEmSegundos % 60;
    }

    // escrever o resultado
    public static void escreverResultado(int horas, int minutos, int segundos) {
        System.out.println(horas + " horas, " + minutos + " minutos e " + segundos + " segundos");
    }

}
