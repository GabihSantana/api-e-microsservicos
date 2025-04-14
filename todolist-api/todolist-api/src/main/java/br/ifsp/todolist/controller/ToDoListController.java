package br.ifsp.todolist.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ifsp.todolist.dto.TarefaPatchDTO;
import br.ifsp.todolist.dto.TarefaRequestDTO;
import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.service.ToDoListService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class ToDoListController {

	@Autowired
	private ToDoListService toDoListService;

	@PostMapping
	@Operation(summary = "Criar uma nova tarefa")
	@ResponseStatus(HttpStatus.CREATED)
	public TarefaResponseDTO createTask(@Valid @RequestBody TarefaRequestDTO tarefaRequestDTO) {
		return toDoListService.createTask(tarefaRequestDTO);
	}

	@GetMapping
	@Operation(summary = "Listar tarefas com paginação")
	public Page<TarefaResponseDTO> getAllTasks(@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int size,
												@RequestParam(defaultValue = "prioridade") String sort) {
		return toDoListService.getAllTasks(page, size, sort);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Buscar tarefa por ID")
	public TarefaResponseDTO getTasksById(@PathVariable Long id) {
		return toDoListService.getTasksById(id);
	}

	@GetMapping("/search")
	@Operation(summary = "Buscar tarefas por categoria")
	public Page<TarefaResponseDTO> getTaskByCategoria(@RequestParam String categoria, Pageable pageable) {
		return toDoListService.getTaskByCategoria(categoria, pageable);
	}

	@PatchMapping("/{id}")
	@Operation(summary = "Atualização parcial da tarefa")
	public TarefaResponseDTO updateTaskField(@PathVariable Long id, @RequestBody TarefaPatchDTO tarefaPatchDTO) {
		return toDoListService.updateTaskField(id, tarefaPatchDTO);
	}

	@PatchMapping("/{id}/concluir")
	@Operation(summary = "Marcar tarefa como concluída")
	public TarefaResponseDTO updateTaskStatus(@PathVariable Long id, @RequestBody TarefaPatchDTO tarefaPatchDTO) {
		return toDoListService.updateTaskStatus(id, tarefaPatchDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualização completa da tarefa")
	public TarefaResponseDTO updateTask(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO tarefaRequestDTO) {
		return toDoListService.updateTask(id, tarefaRequestDTO);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover tarefa (se ainda não estiver concluída)")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable Long id) {
		toDoListService.deleteTask(id);
	}

}
