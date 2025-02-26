package classesAbstratas;

public class TestaCadastro {

	public static void main(String[] args) {
	    Data data1 = new Data(15, 5, 1990);
        Data data2 = new Data(22, 8, 1985);
        Data data3 = new Data(10, 12, 1975);
        
        Cliente cliente = new Cliente(101, "João Silva", data1);
        Funcionario funcionario = new Funcionario(3500.00, "Maria Oliveira", data2);
        Gerente gerente = new Gerente("TI", 8000.00, "Carlos Souza", data3);
        
        CadastroPessoas.cadastraPessoa(cliente);
        CadastroPessoas.cadastraPessoa(funcionario);
        CadastroPessoas.cadastraPessoa(gerente);
        
        CadastroPessoas.imprimeCadastro();
	}

}
