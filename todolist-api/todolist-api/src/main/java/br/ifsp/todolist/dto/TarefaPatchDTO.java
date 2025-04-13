package br.ifsp.todolist.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.constraints.DataNoFuturo;
import br.ifsp.todolist.enums.PrioridadeTarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarefaPatchDTO {
	private Optional<String> titulo = Optional.empty();
	private Optional<String> descricao = Optional.empty();
	private Optional<PrioridadeTarefa> prioridade = Optional.empty();
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DataNoFuturo
	private Optional<LocalDate> dataLimite = Optional.empty();
	
	private Optional<Boolean> concluida = Optional.empty();
	private Optional<String> categoria = Optional.empty();
}
