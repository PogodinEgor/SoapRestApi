package ru.pogodin.soap.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketErrorResponse {
    private String message;
    private Long timestamp;

}
