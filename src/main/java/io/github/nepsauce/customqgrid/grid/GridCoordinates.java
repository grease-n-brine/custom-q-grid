package io.github.nepsauce.customqgrid.grid;

import io.github.nepsauce.customqgrid.core.Point2D;

public final class GridCoordinates {
    private GridCoordinates() {
    }

    public static boolean isInBounds(int x, int y, int width, int height) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public static boolean isInBounds(Point2D point, int width, int height) {
        return isInBounds(point.x(), point.y(), width, height);
    }

    public static int toLinearIndex(int x, int y, int width) {
        return y * width + x;
    }
}
