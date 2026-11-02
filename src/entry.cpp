#include <iostream>
#include "bidimensional_environment.hpp"
#include "bidimensional_discrete_movement.hpp"
#include "obstacle.hpp"
#include "bidimensional_discrete_agent.hpp"

int main() {
    DiscreteAgent agent;
    std::vector<DiscreteAgent> agents;
    
    for (int i = 0; i < 1; ++i) {
        agents.push_back(agent);
    }
    
    std::vector<std::vector<Cell>> grid;
    BidimensionalEnvironment env(10, 10, agent, createGrid(10, 10));
    env.addCell(Cell{{agent.getPosX(), agent.getPosY()}, CellType::Empty, 0.0, false});
}

std::vector<std::vector<Cell>> createGrid(int width, int height) {
    std::vector<std::vector<Cell>> grid(height, std::vector<Cell>(width));
    return grid;
}
