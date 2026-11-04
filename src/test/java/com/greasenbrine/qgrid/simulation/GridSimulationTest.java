package com.greasenbrine.qgrid.simulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.greasenbrine.qgrid.agent.AgentActionExecutor;
import com.greasenbrine.qgrid.agent.DiscreteAgent;
import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;
import com.greasenbrine.qgrid.core.CellType;
import com.greasenbrine.qgrid.core.Point2D;
import com.greasenbrine.qgrid.environment.BidimensionalEnvironment;
import com.greasenbrine.qgrid.movement.BidimensionalDiscreteMovement;
import com.greasenbrine.qgrid.movement.Direction2D;

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
