package br.ifsp.todolist.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoListConfiguration {
	@Bean
    public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper;
    }
}
