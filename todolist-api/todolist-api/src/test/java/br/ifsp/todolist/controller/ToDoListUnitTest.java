package br.ifsp.todolist.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import br.ifsp.todolist.dto.TarefaRequestDTO;
import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.enums.PrioridadeTarefa;
import br.ifsp.todolist.exception.InvalidTaskStateException;
import br.ifsp.todolist.exception.ValidationException;
import br.ifsp.todolist.mapper.PagedResponseMapper;
import br.ifsp.todolist.model.Tarefa;
import br.ifsp.todolist.repository.ToDoListRepository;
import br.ifsp.todolist.service.ToDoListService;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class ToDoListUnitTest {
	
	@Mock
	private ToDoListRepository toDoListRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
    private PagedResponseMapper pagedResponseMapper;
	
	@InjectMocks
	private ToDoListService toDoListService;
	
	@Test
	@DisplayName("Create a task with valid data")
	void testCreateTaskWithValidData() {
        TarefaRequestDTO requestDTO = new TarefaRequestDTO();
		
        // cria o request
        requestDTO.setTitulo("Estudar API");
        requestDTO.setPrioridade(PrioridadeTarefa.ALTA);
        requestDTO.setDataLimite(LocalDate.now().plusDays(2));
        requestDTO.setCategoria("Estudos");
        
        //Tarefa tarefa = new Tarefa();
        Tarefa tarefaSalva = new Tarefa();
        
        tarefaSalva.setId(1L);
        tarefaSalva.setTitulo("Estudar API");
        
        //when(modelMapper.map(requestDTO, Tarefa.class)).thenReturn(tarefa);
        when(toDoListRepository.save(any())).thenReturn(tarefaSalva);
        when(modelMapper.map(tarefaSalva, TarefaResponseDTO.class)).thenReturn(new TarefaResponseDTO());
        
        TarefaResponseDTO response = toDoListService.createTask(requestDTO);
        assertNotNull(response);
	}
	
	@Test
	@DisplayName("Throw Validation Except when due date is past")
	void testValidationDatePast() {
        TarefaRequestDTO requestDTO = new TarefaRequestDTO();

        requestDTO.setTitulo("Data inválida");
        requestDTO.setDataLimite(LocalDate.now().minusDays(1));
        
        assertThrows(ValidationException.class, () -> toDoListService.createTask(requestDTO));
	}
	
	@Test
	@DisplayName("Search for a task with a valid ID")
	void testSearchTaskId_ReturnsTask() {
		Long id = 1L;
		
		Tarefa tarefa = new Tarefa("Estudar API", "Estudar sobre os testes", PrioridadeTarefa.ALTA, LocalDate.now().plusDays(1), false, "Estudos");
        ReflectionTestUtils.setField(tarefa, "id", id); 

        TarefaResponseDTO responseDTO = new TarefaResponseDTO();
        responseDTO.setId(id);
        responseDTO.setTitulo("Estudar API");
        responseDTO.setDescricao("Estudar sobre os testes");
        responseDTO.setPrioridade(PrioridadeTarefa.ALTA);
        responseDTO.setDataLimite(LocalDate.now().plusDays(1));
        responseDTO.setConcluida(false);
        responseDTO.setCategoria("Estudos");
        
        when(toDoListRepository.findById(id)).thenReturn(Optional.of(tarefa));
        when(modelMapper.map(tarefa, TarefaResponseDTO.class)).thenReturn(responseDTO);
        
        TarefaResponseDTO response = toDoListService.getTasksById(id);
        
        assertNotNull(response);
        assertEquals(id, response.getId());    
  	}
	
	@Test
	@DisplayName("Throw error when deleting completed task")
	void testDeletingCompletedTask() {
		Tarefa tarefaCompleta = new Tarefa();
		tarefaCompleta.setId(1L);
		tarefaCompleta.setConcluida(true);
		
		when(toDoListRepository.findById(1L)).thenReturn(Optional.of(tarefaCompleta));
		
		assertThrows(InvalidTaskStateException.class, () -> toDoListService.deleteTask(1L));
		
	}
}
