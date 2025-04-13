package br.ifsp.todolist.constraints;
import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDate implements ConstraintValidator<DataNoFuturo, LocalDate>{

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		// Se a data for anterior a data de hoje, a validação falha
        if (value == null || value.isBefore(LocalDate.now())) {
            return false;
        }

        // Caso contrário, a data é válida
        return true;
	}
}
