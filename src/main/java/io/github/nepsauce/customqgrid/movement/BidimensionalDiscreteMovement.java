package io.github.nepsauce.customqgrid.movement;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Environment2D;

public final class BidimensionalDiscreteMovement implements Movement {
    public BidimensionalDiscreteMovement() {
    }

    @Override
    public AgentState move(AgentState currentState, int deltaX, int deltaY) {
        return new AgentState(
                currentState.name(),
                currentState.id(),
                currentState.posX() + deltaX,
                currentState.posY() + deltaY
        );
    }

    @Override
    public boolean isValidMove(Environment2D environment, AgentState currentState, int deltaX, int deltaY) {
        int nextX = currentState.posX() + deltaX;
        int nextY = currentState.posY() + deltaY;

        if (nextX < 0 || nextY < 0 || nextX >= environment.getWidth() || nextY >= environment.getHeight()) {
            return false;
        }

        return !environment.getGrid().get(nextY).get(nextX).isBlocking();
    }
}
