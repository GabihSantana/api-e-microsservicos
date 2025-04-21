package br.ifsp.todolist.controller;


import static org.junit.jupiter.api.Assertions.*;
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

import br.ifsp.todolist.dto.TarefaResponseDTO;
import br.ifsp.todolist.enums.PrioridadeTarefa;
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
	
	@InjectMocks
	private ToDoListService toDoListService;
	
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
	
	
}
