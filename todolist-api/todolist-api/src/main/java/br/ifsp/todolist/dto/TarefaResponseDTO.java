package br.ifsp.todolist.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.enums.PrioridadeTarefa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarefaResponseDTO {
	private Long id;
	
	@Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
    private String titulo;
    
	@Schema(description = "Descrição detalhada da tarefa", example = "Fazer anotações sobre JPA e Hibernate")
    private String descricao;
    
	@Schema(description = "Prioridade da tarefa (ALTA, MEDIA, BAIXA)", example = "ALTA")
    private PrioridadeTarefa prioridade;

	@Schema(description= "Data limite para realizar a tarefa", pattern = "dd/MM/yyyy", example = "21/04/2025")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;
    
	@Schema(description = "Indica se a tarefa foi concluída", example = "false")
    private Boolean concluida;
	
	@Schema(description = "Categoria da tarefa", example = "Estudos")
    private String categoria;

	@Schema(description = "Data de criação da tarefa", pattern = "dd/MM/yyyy", example = "21/04/2025")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadaEm;

}
