package br.edu.insper.biblioteca.editora.exception;

import br.edu.insper.biblioteca.utils.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class EditoraErrorHandler {

    @ExceptionHandler(EditoraNaoEncontradaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleRuntimeException(EditoraNaoEncontradaException re) {

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setDate(LocalDateTime.now());
        errorResponseDTO.setMessage(re.getMessage());
        errorResponseDTO.setStatusCode(404);
        return errorResponseDTO;

    }

}
