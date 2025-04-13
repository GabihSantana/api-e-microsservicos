package br.ifsp.todolist.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.constraints.DataNoFuturo;
import br.ifsp.todolist.enums.PrioridadeTarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O título não pode estar em branco!")
	private String titulo;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
    @NotNull(message = "A prioridade é obrigatória")
	private PrioridadeTarefa prioridade;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DataNoFuturo
	private LocalDate dataLimite;
	
	private Boolean concluida = false;
	
	@NotBlank(message="A categoria não pode estar vazia!")
	private String categoria;
	
	private LocalDate criadaEm;
	
	/**
	 * @PrePersist executa antes da entidade ser salva no banco de dados.
	 * Atribuindo o valor do criada Em, sendo preenchida automaticamente com a criação
	 */
	
	public Tarefa(String titulo, String descricao, PrioridadeTarefa prioridade, LocalDate dataLimite, Boolean concluida, String categoria) {
	    this.titulo = titulo;
	    this.descricao = descricao;
	    this.prioridade = prioridade;
	    this.dataLimite = dataLimite;
	    this.concluida = concluida;
	    this.categoria = categoria;
	}
	
	@PrePersist
	protected void novaTarefa() {
	    this.criadaEm = LocalDate.now();
	}
}
