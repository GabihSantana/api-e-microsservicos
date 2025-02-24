/**
 *  Crie	dois	vetores	de	50	posições	com	valores	inteiros	aleatórios,	ordene	cada	vetor	
individualmente,	e	combine	os	dois	vetores	gerando	um	novo	vetor	de	100	posições,	de	
forma	que	esse	novo	vetor	já	seja	criado	ordenado.	
 */

package lista;

import java.util.Arrays;
import java.util.Random;

public class Exercicio14 {

	public static void main(String[] args) {
		Random gerador = new Random();

		int[] vetorAleatorio1 = new int[50];
		int[] vetorAleatorio2 = new int[50];
		int[] vetor = new int[vetorAleatorio1.length + vetorAleatorio2.length];
		
		int aux = 0;
        
		System.out.println("\n Vetor 1: ");
		
        for (int i = 0; i < vetorAleatorio1.length; i++) {
        	vetorAleatorio1[i] = gerador.nextInt(100);
        	System.out.print(vetorAleatorio1[i] + " ");
        }
        
		System.out.println("\n Vetor 2: ");
		
        for (int i = 0; i < vetorAleatorio2.length; i++) {
        	vetorAleatorio2[i] = gerador.nextInt(100);
        	System.out.print(vetorAleatorio2[i] + " ");
        }
        
        System.out.println("\n Ordenando os vetores: ");
        
        System.out.println("\n\n Vetor 1: ");
        for (int i = 0; i < vetorAleatorio1.length; i++){
    		for (int j = 0; j < vetorAleatorio1.length - 1; j++){
    			if (vetorAleatorio1[j] > vetorAleatorio1[j + 1]){
    				aux = vetorAleatorio1[j];
    				vetorAleatorio1[j] = vetorAleatorio1[j+1];
    				vetorAleatorio1[j+1] = aux;
    			}
    		}
        }
        for (int i = 0; i < vetorAleatorio1.length; i++) {
        	System.out.print(vetorAleatorio1[i] + " ");
        }
        
        System.out.println("\n\n Vetor 2: ");
        for (int i = 0; i < vetorAleatorio2.length; i++){
    		for (int j = 0; j < vetorAleatorio2.length - 1; j++){
    			if (vetorAleatorio2[j] > vetorAleatorio2[j + 1]){
    				aux = vetorAleatorio2[j];
    				vetorAleatorio2[j] = vetorAleatorio2[j+1];
    				vetorAleatorio2[j+1] = aux;
    			}
    		}
        }
        
        for (int i = 0; i < vetorAleatorio2.length; i++) {
        	System.out.print(vetorAleatorio2[i] + " ");
        }
        
        System.out.println("\n\n Vetor final: ");
        
        System.arraycopy(vetorAleatorio1, 0, vetor, 0, 50);
        System.arraycopy(vetorAleatorio2, 0, vetor, 50, 50);

        Arrays.sort(vetor);
        
        for (int i = 0; i < 100; i++) {
            System.out.print(vetor[i] + " ");
        }
	}

}
