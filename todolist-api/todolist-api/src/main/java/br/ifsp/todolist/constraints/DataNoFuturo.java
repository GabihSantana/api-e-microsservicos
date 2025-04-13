package br.ifsp.todolist.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * @Retention Até quando nossa anotação estará disponível.
 * @Target Elementos que podem ser anotados com essa anotação.
 * @Documented faz com que a anotação apareça nos javadocs quando alguém usar ela.
 * @Constraint indica que essa é uma anotação de validação personalizada.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidDate.class)
public @interface DataNoFuturo {
	String message() default "A data limite deve ser igual ou maior da data atual!";
	
	// grupos de validação
	Class<?> [] groups() default {};
	
	// campo padrão exigido pela especificação Bean Validation.
	Class<? extends Payload>[] payload() default {};
	
}
