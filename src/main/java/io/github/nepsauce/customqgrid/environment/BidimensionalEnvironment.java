package io.github.nepsauce.customqgrid.environment;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import io.github.nepsauce.customqgrid.core.CellType;
import io.github.nepsauce.customqgrid.core.Environment2D;
import io.github.nepsauce.customqgrid.core.Point2D;
import io.github.nepsauce.customqgrid.grid.GridCoordinates;
import java.util.ArrayList;
import java.util.List;

public final class BidimensionalEnvironment implements MutableEnvironment {
    private Environment2D environment;
    private final List<Cell> cells;

    public BidimensionalEnvironment(int width, int height, List<AgentState> agents) {
        this(width, height, agents, List.of());
    }

    public BidimensionalEnvironment(
            int width,
            int height,
            List<AgentState> agents,
            List<List<Cell>> grid
    ) {
        this.environment = new Environment2D(width, height, agents, grid);
        this.cells = new ArrayList<>();

        for (AgentState agent : environment.getAgents()) {
            addCell(new Cell(new Point2D(agent.posX(), agent.posY()), CellType.EMPTY, 0.0, false));
        }
    }

    public Environment2D getEnvironment() {
        return new Environment2D(
            environment.getWidth(),
            environment.getHeight(),
            environment.getAgents(),
            environment.getGrid()
        );
    }

    @Override
    public int getWidth() {
        return environment.getWidth();
    }

    @Override
    public int getHeight() {
        return environment.getHeight();
    }

    @Override
    public List<AgentState> getAgents() {
        return new ArrayList<>(environment.getAgents());
    }

    @Override
    public List<Cell> getCells() {
        return new ArrayList<>(cells);
    }

    @Override
    public Cell getCellAt(int x, int y) {
        if (!isInBounds(x, y)) {
            return new Cell(new Point2D(x, y), CellType.BLOCKED, 0.0, true);
        }

        for (Cell cell : cells) {
            if (cell.getPosition().x() == x && cell.getPosition().y() == y) {
                return cell;
            }
        }

        return new Cell(new Point2D(x, y), CellType.EMPTY, 0.0, false);
    }

    @Override
    public void addCell(Cell cell) {
        for (int i = 0; i < cells.size(); i++) {
            Cell current = cells.get(i);
            if (current.getPosition().x() == cell.getPosition().x()
                    && current.getPosition().y() == cell.getPosition().y()) {
                cells.set(i, cell);
                return;
            }
        }

        cells.add(cell);
    }

    @Override
    public void addCells(List<Cell> newCells) {
        for (Cell cell : newCells) {
            addCell(cell);
        }
    }

    @Override
    public void addAgent(AgentState agent) {
        environment.getAgents().add(agent);
        addCell(new Cell(new Point2D(agent.posX(), agent.posY()), CellType.EMPTY, 0.0, false));
    }

    public void addObstacle(Obstacle obstacle) {
        addCells(obstacle.toCells());
    }

    public void registerObstacleAt(int x, int y) {
        addCell(new Cell(new Point2D(x, y), CellType.BLOCKED, 0.0, true));
    }

    public void setEnvironment(Environment2D newEnvironment) {
        this.environment = newEnvironment;
        cells.clear();

        for (List<Cell> row : newEnvironment.getGrid()) {
            addCells(row);
        }
    }

    @Override
    public boolean isBlocked(int x, int y) {
        if (!isInBounds(x, y)) {
            return true;
        }

        return getCellAt(x, y).isBlocking();
    }

    @Override
    public double getRewardAt(int x, int y) {
        if (!isInBounds(x, y)) {
            return 0.0;
        }

        return getCellAt(x, y).getReward();
    }

    public boolean isInBounds(int x, int y) {
        return GridCoordinates.isInBounds(x, y, getWidth(), getHeight());
    }

    public boolean isOccupied(int x, int y) {
        if (!isInBounds(x, y)) {
            return false;
        }

        for (AgentState agent : getAgents()) {
            if (agent.posX() == x && agent.posY() == y) {
                return true;
            }
        }

        return false;
    }

    public boolean hasObstacleAt(int x, int y) {
        return isInBounds(x, y) && isBlocked(x, y);
    }

    public boolean collidesAt(int x, int y) {
        return !isInBounds(x, y) || hasObstacleAt(x, y);
    }
}
