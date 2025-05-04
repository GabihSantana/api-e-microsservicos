package br.ifsp.todolist.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @RestControllerAdvice intercepta exceções lançadas em qualquer parte
 *                       daaplicação e retorna uma resposta adequada para o
 *                       cliente.
 * 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * Trata exceções de recursos não encontrados (404)
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException exception) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	/**
	 * Trata exceções quando há tentativa de modificar tarefas concluídas (409) - Operação solicitada nao é permitida
	 */
    @ExceptionHandler(InvalidTaskStateException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTaskStateException(InvalidTaskStateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

	/**
	 * Retorna o erro 400 com mensagens amigáveis
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationException(ValidationException exception) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			if (error instanceof FieldError) {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			}
		});
		return ResponseEntity.badRequest().body(errors);
	}

	/**
	 * Trata exceções genéricas que não foram capturadas pelos handlers anteriores :
	 * Fallback
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, String>> handleGenericException(Exception exception) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "Erro interno no servidor. Entre em contato com o suporte.");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
	/*
	 * HttpMessageNotReadableException > Trata todos os erros de desserialização do corpo da requisição
	 * Cuida de todo input que o Spring não consegue transformar nos objetos Java
	 */
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", "Dados inválidos no corpo da requisição. Verifique os campos enviados.");
	    return ResponseEntity.badRequest().body(errorResponse);
	}
	
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
}
