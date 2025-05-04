package br.ifsp.todolist.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ifsp.todolist.constraints.DataNoFuturo;
import br.ifsp.todolist.enums.PrioridadeTarefa;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarefaRequestDTO {
	
	@Schema(description = "Título da tarefa", example = "Estudar Spring Boot")
    @NotBlank(message = "O título não pode estar em branco!")
    @Size(min = 10, max = 100)
    private String titulo;

	@Schema(description = "Descrição detalhada da tarefa", example = "Fazer anotações sobre JPA e Hibernate")
    @Size(max = 255)
    private String descricao;

	@Schema(description = "Prioridade da tarefa (ALTA, MEDIA, BAIXA)", example = "ALTA")
    @NotNull(message = "A prioridade é obrigatória")
    private PrioridadeTarefa prioridade;

	@Schema(description= "Data limite para realizar a tarefa", pattern = "dd/MM/yyyy", example = "21/04/2025")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DataNoFuturo
    private LocalDate dataLimite;

	@Schema(description = "Indica se a tarefa foi concluída", example = "false")
    private Boolean concluida = false;

	@Schema(description = "Categoria da tarefa", example = "Estudos")
    @NotBlank(message = "A categoria não pode estar vazia!")
    private String categoria;    
}
