package org.iakimova.robot.domain.model;

import org.iakimova.robot.domain.exception.DomainException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    void correctInitialisation() {
        Grid grid = new Grid(5,5);
        Coordinate coordinate = new Coordinate(1,2);
        Orientation orientation = Orientation.NORTH;

        Robot robot = new Robot(grid, coordinate, orientation);

        assertEquals(new Coordinate(1,2 ), robot.getCoordinate());
        assertEquals(Orientation.NORTH, robot.getOrientation());

    }

    @Test
    void invalidInitialisation() {
        Grid grid = new Grid(5,5);
        Coordinate invalidCoord = new Coordinate(6,6);

        assertThrows(DomainException.class, () -> {
            new Robot(grid, invalidCoord, Orientation.NORTH);
        });
    }

    @Test
    void moveCorrect() {
        Grid grid = new Grid(5,5);
        Coordinate coordinate = new Coordinate(1,1);
        Orientation orientation = Orientation.NORTH;

        Robot robot = new Robot(grid, coordinate, orientation);

        robot.move();
        assertEquals(new Coordinate(1,2 ), robot.getCoordinate());
    }

    @Test
    void moveIncorrect() {
        Grid grid = new Grid(5, 5);
        Coordinate coordinate = new Coordinate(5, 5);
        Orientation orientation = Orientation.NORTH;

        Robot robot = new Robot(grid, coordinate, orientation);

        assertThrows(DomainException.class, () -> {
            robot.move();
        });

        assertEquals(new Coordinate(5, 5), robot.getCoordinate());
    }

    @Test
    void turnLeftCorrect() {
        Grid grid = new Grid(5,5);
        Robot robot = new Robot(grid, new Coordinate(1,1), Orientation.NORTH);

        robot.turnLeft();
        assertEquals(Orientation.WEST, robot.getOrientation());
    }

    @Test
    void turnRightCorrect() {
        Grid grid = new Grid(5,5);
        Robot robot = new Robot(grid, new Coordinate(1,1), Orientation.NORTH);

        robot.turnRight();
        assertEquals(Orientation.EAST, robot.getOrientation());
    }
}
