#ifndef OBSTACLE_HPP
#define OBSTACLE_HPP

#include <vector>

#include "structs.hpp"

class Obstacle {
    std::vector<Point2D> points;
    CellType type;
    double reward;
    bool blocking;

    public:
        Obstacle();
        Obstacle(const std::vector<Point2D>& obstaclePoints,
                 CellType obstacleType = CellType::Blocked,
                 double obstacleReward = 0.0);

        void addPoint(const Point2D& point);
        void addPoints(const std::vector<Point2D>& obstaclePoints);

        std::vector<Point2D> getPoints() const;
        CellType getType() const;
        double getReward() const;
        bool isBlocking() const;
        bool contains(int x, int y) const;

        std::vector<Cell> toCells() const;
};

#endif // OBSTACLE_HPP
