package br.ifsp.todolist.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.ifsp.todolist.model.Tarefa;
import br.ifsp.todolist.exception.ResourceNotFoundException;
import br.ifsp.todolist.exception.ValidationException;
import br.ifsp.todolist.mapper.PagedResponseMapper;
import br.ifsp.todolist.dto.TarefaPatchDTO;
import br.ifsp.todolist.dto.TarefaRequestDTO;
import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.dto.task.PagedResponse;
import br.ifsp.todolist.exception.InvalidTaskStateException;
import br.ifsp.todolist.repository.ToDoListRepository;

@Service
public class ToDoListService {

	private final ToDoListRepository toDoListRepository;
	private final ModelMapper modelMapper;
	private final PagedResponseMapper pagedResponseMapper;

	public ToDoListService(ToDoListRepository toDoListRepository, ModelMapper modelMapper,
			PagedResponseMapper pagedResponseMapper) {
		this.toDoListRepository = toDoListRepository;
		this.modelMapper = modelMapper;
		this.pagedResponseMapper = pagedResponseMapper;
	}

	// post
	public TarefaResponseDTO createTask(TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = new Tarefa(tarefaRequestDTO.getTitulo(), tarefaRequestDTO.getDescricao(),
				tarefaRequestDTO.getPrioridade(), tarefaRequestDTO.getDataLimite(), tarefaRequestDTO.getConcluida(),
				tarefaRequestDTO.getCategoria());

		if (tarefaRequestDTO.getDataLimite().isBefore(LocalDate.now())) {
			throw new ValidationException("A data limite não pode ser no passado");
		}

		Tarefa savedTarefa = toDoListRepository.save(tarefa);
		return modelMapper.map(savedTarefa, TarefaResponseDTO.class);
	}

	// get
	public PagedResponse<TarefaResponseDTO> getAllTasks(Pageable pageable) {
		Page<Tarefa> tarefas = toDoListRepository.findAll(pageable);
		return pagedResponseMapper.toPagedResponse(tarefas, TarefaResponseDTO.class);
	}

	// get por ID
	public TarefaResponseDTO getTasksById(Long id) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));
		return modelMapper.map(tarefa, TarefaResponseDTO.class);
	}

	// get por Categoria
	public PagedResponse<TarefaResponseDTO> getTaskByCategoria(String categoria, Pageable pageable) {
		Page<Tarefa> tarefas = toDoListRepository.findByCategoriaContainingIgnoreCase(categoria, pageable);
		return pagedResponseMapper.toPagedResponse(tarefas, TarefaResponseDTO.class);
	}

	// patch
	public TarefaResponseDTO updateTaskField(Long id, TarefaPatchDTO tarefaPatchDTO) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));

		if (Boolean.TRUE.equals(tarefa.getConcluida())) {
			throw new InvalidTaskStateException("Tarefas concluídas não podem ser editadas.");
		} else {
			tarefaPatchDTO.getTitulo().ifPresent(tarefa::setTitulo);
			tarefaPatchDTO.getDescricao().ifPresent(tarefa::setDescricao);
			tarefaPatchDTO.getPrioridade().ifPresent(tarefa::setPrioridade);
			tarefaPatchDTO.getDataLimite().ifPresent(tarefa::setDataLimite);
			tarefaPatchDTO.getConcluida().ifPresent(tarefa::setConcluida);
			tarefaPatchDTO.getCategoria().ifPresent(tarefa::setCategoria);

			Tarefa saved = toDoListRepository.save(tarefa);

			return modelMapper.map(saved, TarefaResponseDTO.class);
		}
	}

	// patch status tarefa
	public TarefaResponseDTO updateTaskStatus(Long id) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));

		if (Boolean.TRUE.equals(tarefa.getConcluida())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Tarefas concluídas não podem ser editadas.");
		} else {
			tarefa.setConcluida(true);

			Tarefa saved = toDoListRepository.save(tarefa);

			return modelMapper.map(saved, TarefaResponseDTO.class);
		}
	}

	// put
	public TarefaResponseDTO updateTask(Long id, TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));

		if (Boolean.TRUE.equals(tarefa.getConcluida())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Tarefas concluídas não podem ser editadas.");
		}

		modelMapper.map(tarefaRequestDTO, tarefa);
		tarefa.setId(id);
		tarefa.setCriadaEm(tarefa.getCriadaEm()); // preserva a data original de criação

		Tarefa updated = toDoListRepository.save(tarefa);
		return modelMapper.map(updated, TarefaResponseDTO.class);
	}

	// delete
	public void deleteTask(Long id) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));

		if (Boolean.TRUE.equals(tarefa.getConcluida())) {
			throw new InvalidTaskStateException("Tarefas concluídas não podem ser deletadas.");
		} else {
			toDoListRepository.delete(tarefa);
		}
	}

}
