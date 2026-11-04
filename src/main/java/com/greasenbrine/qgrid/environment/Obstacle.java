package com.greasenbrine.qgrid.environment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.greasenbrine.qgrid.core.Cell;
import com.greasenbrine.qgrid.core.CellType;
import com.greasenbrine.qgrid.core.Point2D;

public final class Obstacle {
    private final List<Point2D> points;
    private CellType type;
    private double reward;
    private boolean blocking;

    public Obstacle() {
        this(List.of(), CellType.BLOCKED, 0.0);
    }

    public Obstacle(Collection<Point2D> obstaclePoints, CellType obstacleType, double obstacleReward) {
        this.points = new ArrayList<>(obstaclePoints);
        this.type = obstacleType;
        this.reward = obstacleReward;
        this.blocking = true;

        if (obstacleType == CellType.POSITIVE_REWARD) {
            reward = obstacleReward > 0.0 ? obstacleReward : 1.0;
            blocking = false;
        } else if (obstacleType == CellType.NEGATIVE_REWARD) {
            reward = obstacleReward < 0.0 ? obstacleReward : -1.0;
            blocking = false;
        } else if (obstacleType == CellType.BLOCKED) {
            reward = 0.0;
            blocking = true;
        } else {
            reward = 0.0;
            blocking = false;
        }
    }

    public void addPoint(Point2D point) {
        points.add(point);
    }

    public void addPoints(Collection<Point2D> obstaclePoints) {
        points.addAll(obstaclePoints);
    }

    public List<Point2D> getPoints() {
        return new ArrayList<>(points);
    }

    public CellType getType() {
        return type;
    }

    public double getReward() {
        return reward;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public boolean contains(int x, int y) {
        for (Point2D point : points) {
            if (point.x() == x && point.y() == y) {
                return true;
            }
        }

        return false;
    }

    public List<Cell> toCells() {
        List<Cell> cells = new ArrayList<>(points.size());

        for (Point2D point : points) {
            cells.add(new Cell(point, type, reward, blocking));
        }

        return cells;
    }
}
