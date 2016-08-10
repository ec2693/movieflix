package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class MovieDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 405802649322364762L;

	public MovieDoesNotExistsException(String message) {
		super(message);
	}

	public MovieDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
