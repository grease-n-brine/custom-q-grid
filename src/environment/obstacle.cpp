#include "obstacle.hpp"

Obstacle::Obstacle()
    : points(),
      type(CellType::Blocked),
      reward(0.0),
      blocking(true) {}

Obstacle::Obstacle(const std::vector<Point2D>& obstaclePoints,
                   CellType obstacleType,
                   double obstacleReward)
    : points(obstaclePoints),
      type(obstacleType),
      reward(obstacleReward),
      blocking(true) {
    if (obstacleType == CellType::PositiveReward) {
        reward = obstacleReward > 0.0 ? obstacleReward : 1.0;
        blocking = false;
    } else if (obstacleType == CellType::NegativeReward) {
        reward = obstacleReward < 0.0 ? obstacleReward : -1.0;
        blocking = false;
    } else if (obstacleType == CellType::Blocked) {
        reward = 0.0;
        blocking = true;
    } else {
        reward = 0.0;
        blocking = false;
    }
}

void Obstacle::addPoint(const Point2D& point) {
    points.push_back(point);
}

void Obstacle::addPoints(const std::vector<Point2D>& obstaclePoints) {
    points.insert(points.end(), obstaclePoints.begin(), obstaclePoints.end());
}

std::vector<Point2D> Obstacle::getPoints() const {
    return points;
}

CellType Obstacle::getType() const {
    return type;
}

double Obstacle::getReward() const {
    return reward;
}

bool Obstacle::isBlocking() const {
    return blocking;
}

bool Obstacle::contains(int x, int y) const {
    for (const auto& point : points) {
        if (point.x == x && point.y == y) {
            return true;
        }
    }

    return false;
}

std::vector<Cell> Obstacle::toCells() const {
    std::vector<Cell> cells;
    cells.reserve(points.size());

    for (const auto& point : points) {
        Cell cell;
        cell.position = point;
        cell.type = type;
        cell.reward = reward;
        cell.blocking = blocking;
        cells.push_back(cell);
    }

    return cells;
}
