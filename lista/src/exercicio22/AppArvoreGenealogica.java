/**
 * 22. Faça	uma	programa	para	representar	a	árvore	genealógica	de	uma	família.	Para	tal,	crie	
uma	classe	Pessoa	que	permita	indicar,	além	de	nome	e	idade,	o	pai	e	a	mãe.	Tenha	em	
mente	que	pai	e	mãe	também	são	do	tipo	Pessoa.	
 */
package exercicio22;

public class AppArvoreGenealogica {

	public static void main(String[] args) {
		
		Pessoa paiPaterno = new Pessoa("João", 65, null, null);
        Pessoa maePaterno = new Pessoa("Maria", 63, null, null);
        Pessoa paiMaterno = new Pessoa("José", 69, null, null);
        Pessoa maeMaterna = new Pessoa("Helena", 72, null, null);

        Pessoa pai = new Pessoa("Ricardo", 40, paiPaterno, maePaterno);
        Pessoa mae = new Pessoa("Ana", 38, paiMaterno, maeMaterna);

        Pessoa filho = new Pessoa("Noah", 10, pai, mae);

        filho.mostrarArvoreGenealogica();
		
	}

}
