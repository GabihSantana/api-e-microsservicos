package br.ifsp.todolist.exception;

public class ValidationException extends RuntimeException {
	public ValidationException(String message) {
		super(message);
	}
}
