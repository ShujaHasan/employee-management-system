package employee_management.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private String path;

    public ErrorResponse(){}

    public ErrorResponse(LocalDateTime timeStamp, int status,String message, String path){
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
