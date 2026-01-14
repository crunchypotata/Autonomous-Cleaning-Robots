package org.iakimova.robot.domain.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @Test
    @DisplayName("Should rotate right correctly in a full circle")
    void turnRightCorrectly() {
        assertEquals(Orientation.EAST, Orientation.NORTH.turnRight());
        assertEquals(Orientation.SOUTH, Orientation.EAST.turnRight());
        assertEquals(Orientation.WEST, Orientation.SOUTH.turnRight());
        assertEquals(Orientation.NORTH, Orientation.WEST.turnRight());
    }

    @Test
    @DisplayName("Should rotate left correctly in a full circle")
    void turnLeftCorrectly() {
        assertEquals(Orientation.WEST, Orientation.NORTH.turnLeft());
        assertEquals(Orientation.SOUTH, Orientation.WEST.turnLeft());
        assertEquals(Orientation.EAST, Orientation.SOUTH.turnLeft());
        assertEquals(Orientation.NORTH, Orientation.EAST.turnLeft());
    }

    @Test
    @DisplayName("Turning right and then left should return to original orientation")
    void turnRightAndLeftShouldReturnToOriginal() {
        Orientation start = Orientation.NORTH;
        assertEquals(start, start.turnRight().turnLeft());
    }
}
