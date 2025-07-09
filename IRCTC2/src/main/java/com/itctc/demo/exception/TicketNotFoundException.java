package com.itctc.demo.exception;

public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException() {
        super("Ticket not found");
    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
