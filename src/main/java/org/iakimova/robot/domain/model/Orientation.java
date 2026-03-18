package org.iakimova.robot.domain.model;
import org.iakimova.robot.domain.exception.DomainException;

public enum Orientation {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String label;

    Orientation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Orientation fromLabel(String label) throws DomainException {
        for(Orientation o: values()) {
            if (o.label.equalsIgnoreCase(label)) {
                return o;
            }
        }
        throw new DomainException("Invalid orientation label: " + label);
    }

    public int getStepX() {
        return switch (this) {
            case EAST -> 1;
            case WEST -> -1;
            default -> 0;
        };
    }

    public int getStepXOpposite() {
        return switch (this) {
            case EAST -> -1;
            case WEST -> 1;
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

    public int getStepYOpposite() {
        return switch (this) {
            case NORTH -> -1;
            case SOUTH -> 1;
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
