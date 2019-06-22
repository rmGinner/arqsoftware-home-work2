package br.rmginner.exception;

import br.rmginner.dto.error.MessageErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<MessageErrorDto> handlerBusinessValidationException(BusinessValidationException ex) {
        return new ResponseEntity<>(new MessageErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        ), HttpStatus.BAD_REQUEST);
    }
}
