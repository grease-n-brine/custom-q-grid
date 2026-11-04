package com.greasenbrine.qgrid.movement;

public enum Direction2D {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    STAY(0, 0);

    private final int deltaX;
    private final int deltaY;

    Direction2D(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int deltaX() {
        return deltaX;
    }

    public int deltaY() {
        return deltaY;
    }
}
