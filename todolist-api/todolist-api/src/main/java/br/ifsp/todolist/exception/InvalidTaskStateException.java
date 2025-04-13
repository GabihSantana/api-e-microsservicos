package br.ifsp.todolist.exception;

public class InvalidTaskStateException extends RuntimeException{
	 public InvalidTaskStateException(String message) {
	        super(message);
	    }
}
