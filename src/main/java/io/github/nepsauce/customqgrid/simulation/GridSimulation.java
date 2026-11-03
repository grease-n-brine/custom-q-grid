package io.github.nepsauce.customqgrid.simulation;

import io.github.nepsauce.customqgrid.agent.AgentActionExecutor;
import io.github.nepsauce.customqgrid.agent.DiscreteAgent;
import io.github.nepsauce.customqgrid.environment.BidimensionalEnvironment;
import io.github.nepsauce.customqgrid.movement.Direction2D;
import java.util.Map;

public final class GridSimulation {
    private final BidimensionalEnvironment environment;
    private final AgentActionExecutor actionExecutor;

    public GridSimulation(BidimensionalEnvironment environment, AgentActionExecutor actionExecutor) {
        this.environment = environment;
        this.actionExecutor = actionExecutor;
    }

    public void step(Map<DiscreteAgent, Direction2D> actions) {
        for (Map.Entry<DiscreteAgent, Direction2D> action : actions.entrySet()) {
            actionExecutor.tryMove(action.getKey(), environment, action.getValue());
        }
    }

    public BidimensionalEnvironment getEnvironment() {
        return environment;
    }
}
