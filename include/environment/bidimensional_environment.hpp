#ifndef BIDIMENSIONAL_ENVIRONMENT_HPP
#define BIDIMENSIONAL_ENVIRONMENT_HPP

#include <vector>

#include "obstacle.hpp"
#include "structs.hpp"

class BidimensionalEnvironment {
    Environment2D env;
    std::vector<Cell> cells;

    public:
        BidimensionalEnvironment(int width, int height, std::vector<Agent> agents);
        BidimensionalEnvironment(int width, int height, std::vector<Agent> agents,
                                const std::vector<std::vector<Cell>>& grid);

        int getWidth() const;
        int getHeight() const;
        Environment2D getEnvironment() const;
        std::vector<Cell> getCells() const;
        std::vector<Agent> getAgents() const;
        Cell getCellAt(int x, int y) const;

        void setEnvironment(const Environment2D& newEnv);
        void addCell(const Cell& cell);
        void addCells(const std::vector<Cell>& newCells);
        void addAgent(const Agent& agent);
        void addObstacle(const Obstacle& obstacle);

        bool isBlocked(int x, int y) const;
        double getRewardAt(int x, int y) const;
};

#endif // BIDIMENSIONAL_ENVIRONMENT_HPP