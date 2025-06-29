package com.anthonycorp.reservapp.Utils.dto;

import com.anthonycorp.reservapp.Utils.controllerAdvice.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class ErrorDto {
    private String message;
    private ErrorCodes errorCode;
    private List<String> details;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
}
