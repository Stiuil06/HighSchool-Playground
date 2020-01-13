package com.praca.zespolowa.exception;

import java.sql.SQLException;

public class CoffeeQueryException extends RuntimeException {
    public CoffeeQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeQueryException(SQLException e) {
        super(e);
    }
}
