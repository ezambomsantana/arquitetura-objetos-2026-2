package br.edu.insper.biblioteca.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String message;
    private int statusCode;
    private LocalDateTime date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
