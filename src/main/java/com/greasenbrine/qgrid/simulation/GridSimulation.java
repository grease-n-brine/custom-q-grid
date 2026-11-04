package com.greasenbrine.qgrid.simulation;

import java.util.Map;

import com.greasenbrine.qgrid.agent.AgentActionExecutor;
import com.greasenbrine.qgrid.agent.DiscreteAgent;
import com.greasenbrine.qgrid.environment.BidimensionalEnvironment;
import com.greasenbrine.qgrid.movement.Direction2D;

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
