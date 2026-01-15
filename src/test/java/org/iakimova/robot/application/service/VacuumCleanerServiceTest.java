package org.iakimova.robot.application.service;

import org.iakimova.robot.domain.exception.DomainException;
import org.iakimova.robot.domain.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacuumCleanerServiceTest {

    @Test
    void parseInstructions() throws DomainException {
        Grid grid = new Grid(5, 5);
        Coordinate startCoord = new Coordinate(1, 2);
        Robot robot = new Robot(grid, startCoord, Orientation.NORTH);

        VacuumCleanerService service = new VacuumCleanerService(robot);

        service.execute("LMLMLMLMM");

        assertEquals(new Coordinate(1, 3), robot.getCoordinate());
        assertEquals(Orientation.NORTH, robot.getOrientation());
    }
}