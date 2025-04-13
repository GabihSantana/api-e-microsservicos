package br.ifsp.todolist.dto;

import java.time.LocalDate;

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
public class TarefaResponseDTO {
	private Long id;
    private String titulo;
    private String descricao;
    private PrioridadeTarefa prioridade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;

    private Boolean concluida;
    private String categoria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadaEm;

}
