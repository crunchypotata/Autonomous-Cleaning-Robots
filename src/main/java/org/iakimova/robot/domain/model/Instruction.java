package org.iakimova.robot.domain.model;

import org.iakimova.robot.domain.exception.DomainException;

import java.util.List;

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

    public static List<Instruction> parse(String instructions) {
        return instructions.chars()
                .mapToObj(c -> fromChar((char) c))
                .toList();
    }

}
