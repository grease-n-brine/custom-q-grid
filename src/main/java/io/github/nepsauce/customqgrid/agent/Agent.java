package io.github.nepsauce.customqgrid.agent;

import io.github.nepsauce.customqgrid.core.AgentState;

public interface Agent {
    int getId();

    String getName();

    int getPosX();

    int getPosY();

    AgentState getState();
}
