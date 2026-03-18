package org.iakimova.robot.domain.model;

import java.util.*;

public class Grid{

    private final int maxX;
    private final int maxY;
    private final Set<Coordinate> obstacles = new HashSet<>();
    private final List<Robot> robots = new ArrayList<>();

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void addObstacle(int x, int y) {
        obstacles.add(new Coordinate(x,y));
    }

    public boolean isAvailable(Coordinate coordinate) {
        return isWithinBounds(coordinate) && !obstacles.contains(coordinate);
    }

    public boolean isWithinBounds(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() <= maxX &&
                coordinate.y() >= 0 && coordinate.y() <= maxY;
    }
}
