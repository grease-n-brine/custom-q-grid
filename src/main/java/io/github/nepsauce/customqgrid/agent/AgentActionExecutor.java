package io.github.nepsauce.customqgrid.agent;

import io.github.nepsauce.customqgrid.environment.BidimensionalEnvironment;
import io.github.nepsauce.customqgrid.movement.BidimensionalDiscreteMovement;
import io.github.nepsauce.customqgrid.movement.Direction2D;

public final class AgentActionExecutor {
    private final BidimensionalDiscreteMovement movement;

    public AgentActionExecutor(BidimensionalDiscreteMovement movement) {
        this.movement = movement;
    }

    public boolean tryMove(DiscreteAgent agent, BidimensionalEnvironment environment, int deltaX, int deltaY) {
        if (!movement.isValidMove(environment.getEnvironment(), agent.getState(), deltaX, deltaY)) {
            return false;
        }

        agent.applyState(movement.move(agent.getState(), deltaX, deltaY));
        return true;
    }

    public boolean tryMove(DiscreteAgent agent, BidimensionalEnvironment environment, Direction2D direction) {
        return tryMove(agent, environment, direction.deltaX(), direction.deltaY());
    }
}
