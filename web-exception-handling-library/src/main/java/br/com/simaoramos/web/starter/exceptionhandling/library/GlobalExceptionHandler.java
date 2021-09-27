package br.com.simaoramos.web.starter.exceptionhandling.library;

import br.com.simaoramos.core.exception.RecordAlreadyExistsException;
import br.com.simaoramos.core.exception.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ExceptionResponseFactory exceptionResponseFactory;

    @ExceptionHandler(value = {RecordAlreadyExistsException.class})
    public ResponseEntity<ExceptionResponse> handleBadRequest(Exception ex, ServletWebRequest request) {
        return this.exceptionResponseFactory.exceptionResponse(BAD_REQUEST, ex, request);
    }

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNotFound(Exception ex, ServletWebRequest request) {
        return this.exceptionResponseFactory.exceptionResponse(NOT_FOUND, ex, request);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleServerError(Exception ex, ServletWebRequest request) {
        return this.exceptionResponseFactory.exceptionResponse(INTERNAL_SERVER_ERROR, ex, request);
    }
}
