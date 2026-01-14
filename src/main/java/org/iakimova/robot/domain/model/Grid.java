package org.iakimova.robot.domain.model;

public record Grid(int maxX, int maxY) {

    public boolean isWithinBounds(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() <= maxX &&
                coordinate.y() >= 0 && coordinate.y() <= maxY();
    }
}
