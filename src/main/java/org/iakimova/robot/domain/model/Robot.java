package org.iakimova.robot.domain.model;
import org.iakimova.robot.domain.exception.DomainException;

public class Robot {

    private final Grid grid;
    private Coordinate coordinate;
    private Orientation orientation;

    public Robot (Grid grid, Coordinate coordinate, Orientation orientation) throws DomainException {
        this.grid = grid;
        this.orientation = orientation;

        if (!grid.isWithinBounds(coordinate)) {
            throw new DomainException("Robot cannot be placed outside the grid boundaries");
        }

        this.coordinate = coordinate;
    }

    public void move() {
        Coordinate nextCoordinate = this.coordinate.add(orientation.getStepX(), orientation.getStepY());

        if(grid.isWithinBounds(nextCoordinate)) {
            this.coordinate = nextCoordinate;
        } else {
            throw new DomainException("Movement denied: coordinate " + nextCoordinate.x() + " " + nextCoordinate.y() + " is outside the grid.");
        }
    }

    public void backwardMove() {
        Coordinate nextCoordinate = this.coordinate.add(orientation.getStepXOpposite(), orientation.getStepYOpposite());

        if(grid.isWithinBounds(nextCoordinate)) {
            this.coordinate = nextCoordinate;
        } else {
            throw new DomainException("Movement denied: coordinate " + nextCoordinate.x() + " " + nextCoordinate.y() + " is outside the grid.");
        }

    }

    public void turnLeft() {
        this.orientation = this.orientation.turnLeft();
    }

    public void turnRight() {
        this.orientation = this.orientation.turnRight();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Grid getGrid() {
        return grid;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
