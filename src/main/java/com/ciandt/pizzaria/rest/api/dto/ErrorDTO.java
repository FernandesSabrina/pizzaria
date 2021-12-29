package com.ciandt.pizzaria.rest.api.dto;

import java.time.LocalDateTime;

public class ErrorDTO {

    LocalDateTime timestamp = LocalDateTime.now();
    int status;
    String error;
    String field;

    public ErrorDTO(int status, String error, String field) {
        this.status = status;
        this.error = error;
        this.field = field;
    }

    public ErrorDTO() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
