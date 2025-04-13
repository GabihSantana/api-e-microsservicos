package br.ifsp.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title="To-Do list API", version="1.0", description = "Documentação da API de Gerenciamento de Tarefas"))
@SpringBootApplication
public class TodolistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApiApplication.class, args);
	}

}
