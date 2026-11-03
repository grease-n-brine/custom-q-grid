package io.github.nepsauce.customqgrid.movement;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Environment2D;

public interface Movement {
    AgentState move(AgentState currentState, int deltaX, int deltaY);

    boolean isValidMove(Environment2D environment, AgentState currentState, int deltaX, int deltaY);
}
