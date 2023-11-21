package ru.mrsinkaaa.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApplicationException extends RuntimeException {

    private final ErrorMessage error;

}
