package com.itemsandprices.manageprices.application.response;


import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private String details;
    private int statusCode;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String details, int statusCode) {
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}