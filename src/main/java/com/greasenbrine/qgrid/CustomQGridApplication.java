package com.greasenbrine.qgrid;

import java.util.ArrayList;
import java.util.List;

import com.greasenbrine.qgrid.agent.AgentActionExecutor;
import com.greasenbrine.qgrid.agent.DiscreteAgent;
import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;
import com.greasenbrine.qgrid.core.CellType;
import com.greasenbrine.qgrid.core.Point2D;
import com.greasenbrine.qgrid.environment.BidimensionalEnvironment;
import com.greasenbrine.qgrid.movement.BidimensionalDiscreteMovement;

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
