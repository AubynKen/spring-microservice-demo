package com.aubynken.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
}
