#include <iostream>
#include "bidimensional_environment.hpp"
#include "bidimensional_discrete_movement.hpp"
#include "obstacle.hpp"
#include "bidimensional_discrete_agent.hpp"

std::vector<std::vector<Cell>> createGrid(int width, int height);

int main() {
    DiscreteAgent agent;
    BidimensionalDiscreteMovement movement;
    std::vector<Agent> agents;
    
    for (int i = 0; i < 1; ++i) {
        agents.push_back(agent.getAgent());
    }

    BidimensionalEnvironment env(10, 10, agents, createGrid(10, 10));
    env.addCell(Cell{{agent.getPosX(), agent.getPosY()}, CellType::Empty, 0.0, false});

    movement.move(agent.getAgent(), 1, 1);
}

std::vector<std::vector<Cell>> createGrid(int width, int height) {
    std::vector<std::vector<Cell>> grid(height, std::vector<Cell>(width));
    return grid;
}
