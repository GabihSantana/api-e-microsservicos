/**
 * Ordene	um	vetor	de	100	números	inteiros	gerados	aleatoriamente.	
 */

package lista;

import java.util.Random;

public class Exercicio13 {

	public static void main(String[] args) {
		Random gerador = new Random();
		
		int[] vetorAleatorio = new int[100];
		int aux = 0;
        
		System.out.println("\n Antes de ordenar: ");
		
        for (int i = 0; i < vetorAleatorio.length; i++) {
        	vetorAleatorio[i] = gerador.nextInt(100);
        	System.out.print(vetorAleatorio[i] + " ");
        }
        
        System.out.println("\n\n Após de ordenar: ");
        
        for (int i = 0; i < vetorAleatorio.length; i++){
    		for (int j = 0; j < vetorAleatorio.length - 1; j++){
    			if (vetorAleatorio[j] > vetorAleatorio[j + 1]){
    				aux = vetorAleatorio[j];
    				vetorAleatorio[j] = vetorAleatorio[j+1];
    				vetorAleatorio[j+1] = aux;
    			}
    		}
        }
        for (int i = 0; i < vetorAleatorio.length; i++) {
        	System.out.print(vetorAleatorio[i] + " ");
        }
	}

}
