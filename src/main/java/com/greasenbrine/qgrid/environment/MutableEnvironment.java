package com.greasenbrine.qgrid.environment;

import java.util.List;

import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;

public interface MutableEnvironment extends Environment {
    void addCell(Cell cell);

    void addCells(List<Cell> cells);

    void addAgent(AgentState agent);
}
