package ru.mrsinkaaa.exceptions.player;

import ru.mrsinkaaa.exceptions.ApplicationException;
import ru.mrsinkaaa.exceptions.ErrorMessage;

public class PlayerNotFoundException extends ApplicationException {
    public PlayerNotFoundException() {
        super(ErrorMessage.USER_NOT_FOUND);
    }
}
