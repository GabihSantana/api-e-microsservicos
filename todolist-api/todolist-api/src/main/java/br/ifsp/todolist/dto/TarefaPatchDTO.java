package br.ifsp.todolist.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.constraints.DataNoFuturo;
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
public class TarefaPatchDTO {
	@Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
	private Optional<String> titulo = Optional.empty();
	
	@Schema(description = "Descrição detalhada da tarefa", example = "Fazer anotações sobre JPA e Hibernate")
	private Optional<String> descricao = Optional.empty();
	
	@Schema(description = "Prioridade da tarefa (ALTA, MEDIA, BAIXA)", example = "ALTA")
	private Optional<PrioridadeTarefa> prioridade = Optional.empty();
	
	@Schema(description= "Data limite para realizar a tarefa", pattern = "dd/MM/yyyy", example = "21/04/2025")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DataNoFuturo
	private Optional<LocalDate> dataLimite = Optional.empty();
	
	@Schema(description = "Indica se a tarefa foi concluída", example = "false")
	private Optional<Boolean> concluida = Optional.empty();
	
	@Schema(description = "Categoria da tarefa", example = "Estudos")
	private Optional<String> categoria = Optional.empty();
}
