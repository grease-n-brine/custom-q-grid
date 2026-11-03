package io.github.nepsauce.customqgrid.environment;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import java.util.List;

public interface Environment {
    int getWidth();

    int getHeight();

    List<AgentState> getAgents();

    List<Cell> getCells();

    Cell getCellAt(int x, int y);

    boolean isBlocked(int x, int y);

    double getRewardAt(int x, int y);
}
