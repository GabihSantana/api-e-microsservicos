package br.ifsp.todolist.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ifsp.todolist.dto.TarefaPatchDTO;
import br.ifsp.todolist.dto.TarefaRequestDTO;
import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.service.ToDoListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Tarefas", description = "API para gerenciamento de tarefas no TO-DO list")
@Validated
@RestController
@RequestMapping("/api/tasks")
public class ToDoListController {

	private final ToDoListService toDoListService;
	
	public ToDoListController(ToDoListService toDoListService) {
		this.toDoListService = toDoListService;
	}

	/**
	 * Cria uma nova Tarefa no Todo list
	 * 
	 * @param tarefaRequestDTO dados da tarefa que será criada
	 * @return tarefa criada
	 */
	
	@Operation(summary = "Criar uma nova tarefa")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@PostMapping
	public ResponseEntity<TarefaResponseDTO> createTask(@Valid @RequestBody TarefaRequestDTO tarefaRequestDTO) {
		TarefaResponseDTO responseDTO = toDoListService.createTask(tarefaRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	/**
	 * Retorna a lista de todas tarefas pertencentes ao ToDo list
	 * 
	 * @param 	page numero da pagina
	 * @param 	size tamanho da pagina
	 * @param 	sort ordenação que será realizada para a exibição
	 * @return	página de tarefas
	 */
	
	@Operation(summary = "Listar tarefas", description="Lista todas as tarefas com paginação")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@GetMapping
	public ResponseEntity<Page<TarefaResponseDTO>> getAllTasks(@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int size,
												@RequestParam(defaultValue = "prioridade") String sort) {
		
		Page<TarefaResponseDTO> responseDTO = toDoListService.getAllTasks(page, size, sort);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Busca a tarefa pelo Id
	 * 
	 * @param id 	identificador da tarefa
	 * @return 		contato encontrado
	 */
	
	@Operation(summary = "Buscar tarefa", description="Busca por ID")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@GetMapping("/{id}")
	public ResponseEntity<TarefaResponseDTO> getTasksById(@PathVariable Long id) {
		TarefaResponseDTO responseDTO = toDoListService.getTasksById(id);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Busca tarefas por categoria 
	 * 
	 * @param categoria	informação da categoria da tarefa buscada
	 * @param pageable 	informações de paginação
	 * @return			página com todos correspondentes a essa categoria
	 */
	
	@Operation(summary = "Buscar tarefas", description="Realiza a busca pela categoria")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@GetMapping("/search")
	public ResponseEntity<Page<TarefaResponseDTO>> getTaskByCategoria(@RequestParam String categoria, Pageable pageable) {
		Page<TarefaResponseDTO> responseDTO = toDoListService.getTaskByCategoria(categoria, pageable);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Atualiza parcialmente a tarefa
	 * 
	 * @param id				identificador da tarefa
	 * @param tarefaPatchDTO	dados a serem atualizados
	 * @return					contato atualizado
	 */
	@PatchMapping("/{id}")
	@Operation(summary = "Atualizar parcialmente a tarefa", description="Atualiza apenas os campos especificados de uma tarefa")
	public ResponseEntity<TarefaResponseDTO> updateTaskField(@PathVariable Long id, @RequestBody TarefaPatchDTO tarefaPatchDTO) {
		TarefaResponseDTO responseDTO = toDoListService.updateTaskField(id, tarefaPatchDTO);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Marca a tarefa como concluida
	 * 
	 * @param id				identificador da tarefa
	 * @param tarefaPatchDTO	dados a serem atualizados
	 * @return					contato atualizado 
	 */
	
	@Operation(summary = "Atualizar parcialmente a tarefa", description="Marca a tarefa como concluída")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Status da tarefa atualizada com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@PatchMapping("/{id}/concluir")
	public ResponseEntity<TarefaResponseDTO> updateTaskStatus(@PathVariable Long id, @RequestBody TarefaPatchDTO tarefaPatchDTO) {
		TarefaResponseDTO responseDTO = toDoListService.updateTaskStatus(id, tarefaPatchDTO);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Atualiza completamente a tarefa
	 * 
	 * @param id					identificador da tarefa
	 * @param tarefaRequestDTO		dados para realizar a atualização
	 * @return						contato atualizado
	 */
	
	@Operation(summary = "Atualização completa da tarefa", description="Atualiza todos os dados de uma tarefa existente")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
		    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@PutMapping("/{id}")
	public ResponseEntity<TarefaResponseDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO tarefaRequestDTO) {
		TarefaResponseDTO responseDTO = toDoListService.updateTask(id, tarefaRequestDTO);
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Remove uma tarefa
	 * 
	 * @param id	identificador da tarefa
	 * @return		resposta sem conteúdo
	 */
	
	@Operation(summary = "Remover tarefa", description="Remove tarefas que ainda não foram concluídas")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso"),
		    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
		    @ApiResponse(responseCode = "403", description = "Acesso negado", content = @Content)
		})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		toDoListService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}

}
