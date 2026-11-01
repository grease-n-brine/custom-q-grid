#include "bidimensional_discrete_movement.hpp"
#include "structs.hpp"

BidimensionalDiscreteMovement::BidimensionalDiscreteMovement() = default;

Agent BidimensionalDiscreteMovement::move(const Agent& currentState, int deltaX, int deltaY) const {
    Agent nextState = currentState;
    nextState.pos_x += deltaX;
    nextState.pos_y += deltaY;
    return nextState;
}

// Checks if a move is valid based on the current state and the specified deltas.
// Parameters:
// - env: The environment in which the agent is moving.
// - currentState: The current state of the agent.
// - deltaX: The change in the x-coordinate.
// - deltaY: The change in the y-coordinate.
// Returns:
// - true if the move is valid, false otherwise.
// how this works:
bool BidimensionalDiscreteMovement::isValidMove(const Environment2D& env, const Agent& currentState, int deltaX, int deltaY) const {
    int nextX = currentState.pos_x + deltaX;
    int nextY = currentState.pos_y + deltaY;

    // Check if the next position is within the environment bounds
    if (nextX < 0 || nextY < 0 || nextX >= env.width || nextY >= env.height) {
        return false;
    }

    if (env.grid[nextY][nextX].blocking) {
        return false;
    }

    return true;
}
