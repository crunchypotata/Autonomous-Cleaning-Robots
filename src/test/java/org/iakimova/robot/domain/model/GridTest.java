package org.iakimova.robot.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void coordinateCorrect() {

        Grid grid = new Grid(5,5);
        assertTrue(grid.isWithinBounds(new Coordinate(0,0)));
        assertTrue(grid.isWithinBounds(new Coordinate(5,5)));
    }

    @Test
    void coordinateInvalid() {

        Grid grid = new Grid(5,5);
        assertFalse(grid.isWithinBounds(new Coordinate(6,5)));
        assertFalse(grid.isWithinBounds(new Coordinate(-1,2)));
    }
}
