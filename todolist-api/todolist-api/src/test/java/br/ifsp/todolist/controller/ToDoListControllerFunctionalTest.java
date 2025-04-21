package br.ifsp.todolist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ToDoListControllerFunctionalTest {
	 @Autowired
	 private MockMvc mockMvc;
	 
	@Test
	@DisplayName("Create a new task with valid fields")
	void testCreateValidTask_ReturnsCreated() throws Exception{
		String json = """
		 		{
		 			"titulo": "Revisar API",
		 			"descricao": "Revisar todos os endpoints da API",
		 			"prioridade": "ALTA",
		 			"dataLimite": "25/12/2025",
		 			"concluida": false,
		 			"categoria": "Estudos"
		 		}
		 	""";
		 
		mockMvc.perform(post("/api/tasks")
				 .contentType("application/json")
				 .content(json))
		 		 .andDo(print())
		 		 .andExpect(status().isCreated())
		 		 .andExpect(jsonPath("$.titulo").value("Revisar API"))
		 		 .andExpect(jsonPath("$.prioridade").value("ALTA"));
	 }
	
	@Test
	@DisplayName("Create a new task with an invalid data field")
	void testCreateInvalidTask_Error() throws Exception {
		String json = """
		 		{
		 			"titulo": "Revisar API",
		 			"descricao": "Revisar todos os endpoints da API",
		 			"prioridade": "ALTA",
		 			"dataLimite": "10/04/2025",
		 			"concluida": false,
		 			"categoria": "Estudos"
		 		}
		 	""";
		
		mockMvc.perform(post("/api/tasks")
				 .contentType("application/json")
				 .content(json))
		 		 .andDo(print())
		 		 .andExpect(status().isBadRequest());
	}
	
}
