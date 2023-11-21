package ru.mrsinkaaa.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    USER_NOT_FOUND("User not found", HttpServletResponse.SC_NOT_FOUND),
    INVALID_DATA("Invalid data", HttpServletResponse.SC_BAD_REQUEST);

    private final String message;
    private final int status;
}
