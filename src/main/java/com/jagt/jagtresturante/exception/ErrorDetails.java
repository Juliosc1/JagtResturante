package com.jagt.jagtresturante.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class ErrorDetails {
    private Date timeStamp;
    private String message;
    private String details;

    public ErrorDetails(Date timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

}
