package com.greasenbrine.qgrid.movement;

import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Environment2D;

public interface Movement {
    AgentState move(AgentState currentState, int deltaX, int deltaY);

    boolean isValidMove(Environment2D environment, AgentState currentState, int deltaX, int deltaY);
}
