package org.iakimova.robot.domain.model;

import org.iakimova.robot.domain.exception.DomainException;

public enum Instruction {
    L,
    R,
    M;

    public static Instruction fromChar(char code) {
        return switch (Character.toUpperCase(code)) {
            case 'L' -> L;
            case 'R' -> R;
            case 'M' -> M;
            default -> throw new DomainException("Unknown instruction: " + code);
        };
    }
}
