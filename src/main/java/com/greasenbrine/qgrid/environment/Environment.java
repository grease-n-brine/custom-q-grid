package com.greasenbrine.qgrid.environment;

import java.util.List;

import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;

public interface Environment {
    int getWidth();

    int getHeight();

    List<AgentState> getAgents();

    List<Cell> getCells();

    Cell getCellAt(int x, int y);

    boolean isBlocked(int x, int y);

    double getRewardAt(int x, int y);
}
