package org.iakimova.robot.domain.model;

public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Orientation turnRight() {
        int nextOrdinal = (this.ordinal() + 1) % values().length;
        return values()[nextOrdinal];
    }
    public Orientation turnLeft() {
        int nextOrdinal = (this.ordinal() + 3) % values().length;
        return values()[nextOrdinal];
    }
}
