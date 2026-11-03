#ifndef BIDIMENSIONAL_DISCRETE_MOVEMENT_HPP
#define BIDIMENSIONAL_DISCRETE_MOVEMENT_HPP

#include "structs.hpp"

class BidimensionalDiscreteMovement {
    public:
        BidimensionalDiscreteMovement();

        Agent move(const Agent& currentState, int deltaX, int deltaY) const;
        bool isValidMove(const Environment2D& env, const Agent& currentState, int deltaX, int deltaY) const;
};

#endif // BIDIMENSIONAL_DISCRETE_MOVEMENT_HPP
