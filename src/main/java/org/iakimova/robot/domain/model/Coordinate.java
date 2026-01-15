package org.iakimova.robot.domain.model;

public record Coordinate(int x, int y) {

    public Coordinate add(int stepsX, int stepsY) {
        return new Coordinate(this.x + stepsX, this.y + stepsY);
    }

}
