package com.greasenbrine.qgrid.agent;

import com.greasenbrine.qgrid.core.AgentState;

public interface Agent {
    int getId();

    String getName();

    int getPosX();

    int getPosY();

    AgentState getState();
}
