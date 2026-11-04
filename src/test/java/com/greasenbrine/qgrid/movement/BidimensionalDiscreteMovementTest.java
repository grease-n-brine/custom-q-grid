package com.greasenbrine.qgrid.movement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.greasenbrine.qgrid.core.AgentState;
import com.greasenbrine.qgrid.core.Cell;
import com.greasenbrine.qgrid.core.CellType;
import com.greasenbrine.qgrid.core.Environment2D;
import com.greasenbrine.qgrid.core.Point2D;

class BidimensionalDiscreteMovementTest {
    @Test
    void moveAppliesDeltaToPosition() {
        BidimensionalDiscreteMovement movement = new BidimensionalDiscreteMovement();
        AgentState next = movement.move(new AgentState("a", 1, 1, 1), 2, -1);

        assertEquals(3, next.posX());
        assertEquals(0, next.posY());
    }

    @Test
    void validMoveIsRejectedWhenOutOfBounds() {
        BidimensionalDiscreteMovement movement = new BidimensionalDiscreteMovement();
        Environment2D environment = new Environment2D(2, 2, List.of(), createOpenGrid(2, 2));

        assertFalse(movement.isValidMove(environment, new AgentState("a", 1, 0, 0), -1, 0));
    }

    @Test
    void validMoveIsRejectedWhenTargetCellIsBlocked() {
        BidimensionalDiscreteMovement movement = new BidimensionalDiscreteMovement();
        List<List<Cell>> grid = createOpenGrid(3, 3);
        grid.get(1).set(1, new Cell(new Point2D(1, 1), CellType.BLOCKED, 0.0, true));

        Environment2D environment = new Environment2D(3, 3, List.of(), grid);

        assertFalse(movement.isValidMove(environment, new AgentState("a", 1, 0, 1), 1, 0));
        assertTrue(movement.isValidMove(environment, new AgentState("a", 1, 0, 0), 1, 0));
    }

    private static List<List<Cell>> createOpenGrid(int width, int height) {
        List<List<Cell>> grid = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Cell> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                row.add(new Cell(new Point2D(x, y), CellType.EMPTY, 0.0, false));
            }
            grid.add(row);
        }

        return grid;
    }
}
