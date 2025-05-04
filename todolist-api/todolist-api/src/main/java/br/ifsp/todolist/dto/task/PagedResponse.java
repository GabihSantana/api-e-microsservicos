package br.ifsp.todolist.dto.task;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO Genérico para padronizar as respostas paginadas da API

@Data
@AllArgsConstructor
public class PagedResponse<T> {
	private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
