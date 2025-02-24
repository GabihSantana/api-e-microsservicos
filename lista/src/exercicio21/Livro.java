package exercicio21;

public class Livro {
	
	private String titulo;
	private String genero;
	private String autor;
	private String editora;
	private boolean disponivel;
	
	public Livro() {
		
	}
	

	public Livro(String titulo, String genero, String autor, String editora, boolean disponivel) {
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.editora = editora;
		this.disponivel = true;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	@Override
	public String toString() {
	    return "\n Livro " +
	           "Título: '" + titulo + '\'' +
	           ", Gênero: '" + genero + '\'' +
	           ", Autor: '" + autor + '\'' +
	           ", Editora: '" + editora + '\'' +
	           ", Disponível: " + (disponivel ? "Sim" : "Não");
	}
	
	
}
