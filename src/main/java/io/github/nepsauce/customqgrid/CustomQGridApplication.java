package io.github.nepsauce.customqgrid;

import io.github.nepsauce.customqgrid.agent.AgentActionExecutor;
import io.github.nepsauce.customqgrid.agent.DiscreteAgent;
import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import io.github.nepsauce.customqgrid.core.CellType;
import io.github.nepsauce.customqgrid.core.Point2D;
import io.github.nepsauce.customqgrid.environment.BidimensionalEnvironment;
import io.github.nepsauce.customqgrid.movement.BidimensionalDiscreteMovement;
import java.util.ArrayList;
import java.util.List;

public final class CustomQGridApplication {
    private CustomQGridApplication() {
    }

    public static void main(String[] args) {
        DiscreteAgent agent = new DiscreteAgent();
        BidimensionalDiscreteMovement movement = new BidimensionalDiscreteMovement();

        List<AgentState> agents = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            agents.add(agent.getState());
        }

        BidimensionalEnvironment environment =
                new BidimensionalEnvironment(10, 10, agents, createGrid(10, 10));
        environment.addCell(new Cell(new Point2D(agent.getPosX(), agent.getPosY()), CellType.EMPTY, 0.0, false));

        AgentActionExecutor executor = new AgentActionExecutor(movement);
        executor.tryMove(agent, environment, 1, 1);
    }

    static List<List<Cell>> createGrid(int width, int height) {
        List<List<Cell>> grid = new ArrayList<>(height);

        for (int y = 0; y < height; y++) {
            List<Cell> row = new ArrayList<>(width);
            for (int x = 0; x < width; x++) {
                row.add(new Cell(new Point2D(x, y), CellType.EMPTY, 0.0, false));
            }
            grid.add(row);
        }

        return grid;
    }
}
