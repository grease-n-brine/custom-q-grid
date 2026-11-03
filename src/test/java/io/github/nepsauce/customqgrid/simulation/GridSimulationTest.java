package io.github.nepsauce.customqgrid.simulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.nepsauce.customqgrid.agent.AgentActionExecutor;
import io.github.nepsauce.customqgrid.agent.DiscreteAgent;
import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import io.github.nepsauce.customqgrid.core.CellType;
import io.github.nepsauce.customqgrid.core.Point2D;
import io.github.nepsauce.customqgrid.environment.BidimensionalEnvironment;
import io.github.nepsauce.customqgrid.movement.BidimensionalDiscreteMovement;
import io.github.nepsauce.customqgrid.movement.Direction2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GridSimulationTest {
    @Test
    void stepAppliesMoveForEachAgentAction() {
        DiscreteAgent agent = new DiscreteAgent(1, "runner", 0, 0);
        BidimensionalEnvironment environment =
                new BidimensionalEnvironment(4, 4, List.of(new AgentState("runner", 1, 0, 0)));
        environment.addCell(new Cell(new Point2D(1, 0), CellType.EMPTY, 0.0, false));

        GridSimulation simulation =
                new GridSimulation(environment, new AgentActionExecutor(new BidimensionalDiscreteMovement()));

        Map<DiscreteAgent, Direction2D> actions = new HashMap<>();
        actions.put(agent, Direction2D.RIGHT);

        simulation.step(actions);

        assertEquals(1, agent.getPosX());
        assertEquals(0, agent.getPosY());
    }
}
