package org.iakimova.robot.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    @Test
    void AddCoordinatesCorrectly() {
        Coordinate start = new Coordinate(4, 7);
        Coordinate result = start.add(1, -2);

        assertEquals(new Coordinate(5,5), result);
    }
}
