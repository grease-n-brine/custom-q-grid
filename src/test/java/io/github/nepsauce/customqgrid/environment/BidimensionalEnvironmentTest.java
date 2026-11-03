package io.github.nepsauce.customqgrid.environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.nepsauce.customqgrid.core.AgentState;
import io.github.nepsauce.customqgrid.core.Cell;
import io.github.nepsauce.customqgrid.core.CellType;
import io.github.nepsauce.customqgrid.core.Point2D;
import java.util.List;
import org.junit.jupiter.api.Test;

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
