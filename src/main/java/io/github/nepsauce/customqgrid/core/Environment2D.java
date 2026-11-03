package io.github.nepsauce.customqgrid.core;

import java.util.ArrayList;
import java.util.List;

public final class Environment2D {
    private int width;
    private int height;
    private final List<AgentState> agents;
    private final List<List<Cell>> grid;

    public Environment2D(int width, int height) {
        this(width, height, new ArrayList<>(), new ArrayList<>());
    }

    public Environment2D(int width, int height, List<AgentState> agents, List<List<Cell>> grid) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>(agents);
        this.grid = new ArrayList<>();
        for (List<Cell> row : grid) {
            this.grid.add(new ArrayList<>(row));
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<AgentState> getAgents() {
        return agents;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void putCell(int x, int y, Cell cell) {
        while (grid.size() <= y) {
            grid.add(new ArrayList<>());
        }

        List<Cell> row = grid.get(y);
        while (row.size() <= x) {
            row.add(null);
        }

        row.set(x, cell);
    }
}
