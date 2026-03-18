package org.iakimova.robot.domain.model;

import org.iakimova.robot.domain.exception.DomainException;
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

    @Test
    void putObstacle() {
        Grid grid = new Grid(5,5);
        grid.addObstacle(1,2);

        assertFalse(grid.isAvailable(new Coordinate(1,2)));
        assertTrue(grid.isAvailable(new Coordinate(3, 4)));
    }

    @Test
    void obstacleOutBounds() {
        Grid grid = new Grid(5,5);

        assertThrows(DomainException.class, () -> grid.addObstacle(6,6));
    }

    @Test
    void notPlaceRobotOnObstacles() {
        Grid grid = new Grid(5,5);
        grid.addObstacle(1,2);

        Coordinate obstacleCoor = new Coordinate(1,2);
        assertThrows(DomainException.class, () ->
                new Robot(grid, obstacleCoor, Orientation.NORTH));
    }
}
