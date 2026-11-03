package io.github.nepsauce.customqgrid.environment;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import java.util.List;

public interface MutableEnvironment extends Environment {
    void addCell(Cell cell);

    void addCells(List<Cell> cells);

    void addAgent(AgentState agent);
}
