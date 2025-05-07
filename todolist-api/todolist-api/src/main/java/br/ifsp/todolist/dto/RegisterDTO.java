package br.ifsp.todolist.dto;

import br.ifsp.todolist.model.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDTO {
	@NotBlank(message = "Please, enter your username.")
    private String username;
    @NotBlank(message = "Please, enter your password.")
    private String password;
    @NotBlank
    private Role role;

}
