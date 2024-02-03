package ru.pogodin.soap.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorErrorResponse {
    private String message;
    private Long timestamp;

}
