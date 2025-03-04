package aplicacao;

import classesAbstratas.CadastroPessoas;
import classesAbstratas.Cliente;
import classesAbstratas.Data;
import classesAbstratas.Funcionario;
import classesAbstratas.Gerente;

public class TestaCadastro {

	public static void main(String[] args) {
		CadastroPessoas cadatros = new CadastroPessoas();
		
		try {
			Data[] data = new Data[3];
			
		    data[0] = new Data(13, 12, 2000);
	        data[1] = new Data(7, 1, 2005);
	        data[2] = new Data(15, 8, 2005);
	        
	        Cliente cliente = new Cliente(101, "Caio Dib", data[0]);
	        Funcionario funcionario = new Funcionario(3500.00, "Domenico", data[1]);
	        Gerente gerente = new Gerente("TI", 8000.00, "Isabela", data[2]);
	        
	        // preenchendo a lista
	        cadatros.cadastraPessoa(cliente);
	        cadatros.cadastraPessoa(funcionario);
	        cadatros.cadastraPessoa(gerente);
	        
		}
		catch (Exception e){
			System.out.print(e);
		}
		                
        cadatros.imprimeCadastro();
        
	}

}
