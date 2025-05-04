package br.ifsp.todolist.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO de erro para padronizar o corpo das respostas de erro que a API envia ao cliente

@Data
@AllArgsConstructor
public class ErrorResponse {
	private int status; // código HTTP
	private String message;
	private LocalDateTime timestamp;

	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
