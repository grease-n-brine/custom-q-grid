#include "bidimensional_discrete_movement.hpp"

BidimensionalDiscreteMovement::BidimensionalDiscreteMovement() = default;

Agent BidimensionalDiscreteMovement::move(const Agent& currentState, int deltaX, int deltaY) const {
    Agent nextState = currentState;
    nextState.pos_x += deltaX;
    nextState.pos_y += deltaY;
    return nextState;
}

bool BidimensionalDiscreteMovement::isValidMove(const Agent& currentState, int deltaX, int deltaY) const {
    (void)currentState;
    (void)deltaX;
    (void)deltaY;
    return true;
}
