#include "bidimensional_environment.hpp"

#include <algorithm>

BidimensionalEnvironment::BidimensionalEnvironment(int width, int height, std::vector<Agent> agents) {
    env.width = width;
    env.height = height;
    env.agents = std::move(agents);

    for (const auto& agent : env.agents) {
        addCell(Cell{{agent.pos_x, agent.pos_y}, CellType::Empty, 0.0, false});
    }
}

BidimensionalEnvironment::BidimensionalEnvironment(int width, int height, std::vector<Agent> agents,
    const std::vector<std::vector<Cell>>& grid) {
    env.width = width;
    env.height = height;
    env.agents = std::move(agents);
    env.grid = std::move(grid);

    for (const auto& agent : env.agents) {
        addCell(Cell{{agent.pos_x, agent.pos_y}, CellType::Empty, 0.0, false});
    }
}

int BidimensionalEnvironment::getWidth() const {
    return env.width;
}

int BidimensionalEnvironment::getHeight() const {
    return env.height;
}

Environment2D BidimensionalEnvironment::getEnvironment() const {
    return env;
}

// Adds a single cell to the environment, replacing any existing cell at the same position. 
// If no cell exists at the specified position, the cell is added to the environment.
// Parameters:
// - cell: The cell to be added or updated in the environment.
// Returns:
// - void
void BidimensionalEnvironment::addCell(const Cell& cell) {
    auto it = std::find_if(cells.begin(), cells.end(), [&cell](const Cell& current) {
        return current.position.x == cell.position.x && current.position.y == cell.position.y;
    });

    if (it != cells.end()) {
        *it = cell;
        return;
    }

    cells.push_back(cell);
}

void BidimensionalEnvironment::addCells(const std::vector<Cell>& newCells) {
    for (const auto& cell : newCells) {
        addCell(cell);
    }
}

void BidimensionalEnvironment::addObstacle(const Obstacle& obstacle) {
    addCells(obstacle.toCells());
}

bool BidimensionalEnvironment::isBlocked(int x, int y) const {
    auto it = std::find_if(cells.begin(), cells.end(), [x, y](const Cell& cell) {
        return cell.position.x == x && cell.position.y == y;
    });

    return it != cells.end() && it->blocking;
}

double BidimensionalEnvironment::getRewardAt(int x, int y) const {
    auto it = std::find_if(cells.begin(), cells.end(), [x, y](const Cell& cell) {
        return cell.position.x == x && cell.position.y == y;
    });

    if (it == cells.end()) {
        return 0.0;
    }

    return it->reward;
}

Cell BidimensionalEnvironment::getCellAt(int x, int y) const {
    auto it = std::find_if(cells.begin(), cells.end(), [x, y](const Cell& cell) {
        return cell.position.x == x && cell.position.y == y;
    });

    if (it == cells.end()) {
        return Cell{{x, y}, CellType::Empty, 0.0, false};
    }

    return *it;
}

std::vector<Cell> BidimensionalEnvironment::getCells() const {
    return cells;
}

std::vector<Agent> BidimensionalEnvironment::getAgents() const {
    return env.agents;
}

void BidimensionalEnvironment::addAgent(const Agent& agent) {
    env.agents.push_back(agent);
    addCell(Cell{{agent.pos_x, agent.pos_y}, CellType::Empty, 0.0, false});
}

void BidimensionalEnvironment::setEnvironment(const Environment2D& newEnv) {
    env = newEnv;
    cells.clear();

    for (const auto& row : newEnv.grid) {
        for (const auto& cell : row) {
            addCell(cell);
        }
    }
}