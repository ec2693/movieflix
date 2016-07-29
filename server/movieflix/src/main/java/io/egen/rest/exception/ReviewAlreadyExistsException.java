package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ReviewAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 405802649322364762L;

	public ReviewAlreadyExistsException(String message) {
		super(message);
	}

	public ReviewAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
