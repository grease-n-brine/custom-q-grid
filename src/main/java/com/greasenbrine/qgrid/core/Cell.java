package com.greasenbrine.qgrid.core;

public final class Cell {
    private Point2D position;
    private CellType type;
    private double reward;
    private boolean blocking;

    public Cell(Point2D position) {
        this(position, CellType.EMPTY, 0.0, false);
    }

    public Cell(Point2D position, CellType type, double reward, boolean blocking) {
        this.position = position;
        this.type = type;
        this.reward = reward;
        this.blocking = blocking;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }
}
