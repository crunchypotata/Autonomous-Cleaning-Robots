package org.iakimova.robot.domain.exсeption;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
