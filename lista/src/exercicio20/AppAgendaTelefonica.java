package exercicio20;

public class AppAgendaTelefonica {

	public static void main(String[] args) {
		
		Contato[] pessoa = new Contato[2];
		Agenda agenda = new Agenda();
		
		pessoa[0] = new Contato("Snoop", "(11) 99435-5465");
		agenda.adicionarContato(pessoa[0]);
		
		pessoa[1] = new Contato("Nick", "(11) 99653-4353");
	    agenda.adicionarContato(pessoa[1]);
		
		System.out.println("\t ***** Lista de contatos: ******");
		for (Contato contato : agenda.getContatos()) {
			System.out.println("\n Nome: "+ contato.getNome() + " \nTelefone: " + contato.getNumero());
		}		

	}

}
