package br.ifsp.todolist.service;

import java.util.SortedMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.ifsp.todolist.model.Tarefa;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.todolist.dto.TarefaPatchDTO;
import br.ifsp.todolist.dto.TarefaRequestDTO;
import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.exception.InvalidTaskStateException;
import br.ifsp.todolist.repository.ToDoListRepository;

@Service
public class ToDoListService {
	@Autowired
	private ToDoListRepository toDoListRepository;

	@Autowired
	private ModelMapper modelMapper;

	// post
	public TarefaResponseDTO createTask(TarefaRequestDTO tarefaRequestDTO) {
		Tarefa tarefa = new Tarefa(tarefaRequestDTO.getTitulo(), tarefaRequestDTO.getDescricao(),
				tarefaRequestDTO.getPrioridade(), tarefaRequestDTO.getDataLimite(), tarefaRequestDTO.getConcluida(),
				tarefaRequestDTO.getCategoria());

		Tarefa savedTarefa = toDoListRepository.save(tarefa);

		return modelMapper.map(savedTarefa, TarefaResponseDTO.class);
	}

	// get
	public Page<TarefaResponseDTO> getAllTasks(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return toDoListRepository.findAll(pageable).map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
	}

	// get por ID
	public TarefaResponseDTO getTasksById(Long id) {
		Tarefa tarefa = toDoListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));
		return modelMapper.map(tarefa, TarefaResponseDTO.class);
	}

	// get por Categoria
	public Page<TarefaResponseDTO> getTaskByCategoria(String categoria, Pageable pageable) {
		return toDoListRepository.findByCategoriaContainingIgnoreCase(categoria, pageable)
				.map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
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
	public TarefaResponseDTO updateTaskStatus(Long id, TarefaPatchDTO tarefaPatchDTO) {
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

		modelMapper.map(tarefaRequestDTO, tarefa);

		Tarefa updated = toDoListRepository.save(tarefa);

		return modelMapper.map(updated, TarefaResponseDTO.class);
	}
	
	// delete
	public void deleteTask(Long id) {
		toDoListRepository.deleteById(id);
	}

}
