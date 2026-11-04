package com.greasenbrine.qgrid.environment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;
import com.greasenbrine.qgrid.core.CellType;
import com.greasenbrine.qgrid.core.Point2D;

class BidimensionalEnvironmentTest {
    @Test
    void addCellReplacesExistingCellAtSamePosition() {
        BidimensionalEnvironment environment =
                new BidimensionalEnvironment(5, 5, List.of(new AgentState("a", 1, 0, 0)));

        environment.addCell(new Cell(new Point2D(2, 2), CellType.EMPTY, 0.0, false));
        environment.addCell(new Cell(new Point2D(2, 2), CellType.NEGATIVE_REWARD, -2.0, false));

        assertEquals(-2.0, environment.getRewardAt(2, 2));
        assertFalse(environment.isBlocked(2, 2));
    }

    @Test
    void outOfBoundsCellsAreTreatedAsBlocked() {
        BidimensionalEnvironment environment = new BidimensionalEnvironment(3, 3, List.of());

        assertTrue(environment.isBlocked(-1, 0));
        assertTrue(environment.isBlocked(3, 0));
        assertFalse(environment.isInBounds(3, 0));
    }

    @Test
    void obstacleRegistrationMarksCellBlocked() {
        BidimensionalEnvironment environment = new BidimensionalEnvironment(4, 4, List.of());

        environment.registerObstacleAt(1, 1);

        assertTrue(environment.hasObstacleAt(1, 1));
        assertTrue(environment.collidesAt(1, 1));
    }
}
