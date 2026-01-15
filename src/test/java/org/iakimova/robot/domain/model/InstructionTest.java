package org.iakimova.robot.domain.model;

import org.iakimova.robot.domain.exception.DomainException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionTest {

    @Test
    void parseValidInstruction() {
        assertEquals(Instruction.L, Instruction.fromChar('L'));
        assertEquals(Instruction.R, Instruction.fromChar('R'));
        assertEquals(Instruction.M, Instruction.fromChar('M'));
    }

    @Test
    void invalidInstruction() {
        assertThrows(DomainException.class, () -> Instruction.fromChar('X'));
    }
}
