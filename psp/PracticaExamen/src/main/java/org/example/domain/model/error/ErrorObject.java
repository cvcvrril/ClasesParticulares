package org.example.domain.model.error;


import java.time.LocalDateTime;

public class ErrorObject {
    private String message;
    private LocalDateTime fecha;

    public ErrorObject() {
    }

    public ErrorObject(String message, LocalDateTime fecha) {
        this.message = message;
        this.fecha = fecha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
