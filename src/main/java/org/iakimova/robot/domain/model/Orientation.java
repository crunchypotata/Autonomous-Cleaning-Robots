package org.iakimova.robot.domain.model;

public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public int getStepX() {
        return switch (this) {
            case EAST -> 1;
            case WEST -> -1;
            default -> 0;
        };
    }

    public int getStepY() {
        return switch (this) {
            case NORTH -> 1;
            case SOUTH -> -1;
            default -> 0;
            };
        }

    public Orientation turnRight() {
        int nextOrdinal = (this.ordinal() + 1) % values().length;
        return values()[nextOrdinal];
    }
    public Orientation turnLeft() {
        int nextOrdinal = (this.ordinal() + 3) % values().length;
        return values()[nextOrdinal];
    }
}
