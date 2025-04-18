package br.ifsp.todolist.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.constraints.DataNoFuturo;
import br.ifsp.todolist.enums.PrioridadeTarefa;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarefaRequestDTO {
    @NotBlank(message = "O título não pode estar em branco!")
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

    @NotBlank(message = "A categoria não pode estar vazia!")
    private String categoria;    
}
