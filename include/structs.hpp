#pragma once
#ifndef STRUCTS_HPP
#define STRUCTS_HPP

#include <string>
#include <vector>

struct Environment2D {
    int width;
    int height;
    std::vector<Agent> agents;
};

struct Point2D {
    int x;
    int y;
};

enum class CellType {
    Empty,
    Blocked,
    PositiveReward,
    NegativeReward
};

struct Cell {
    Point2D position;
    CellType type = CellType::Empty;
    double reward = 0.0;
    bool blocking = false;
};

struct Agent {
    std::string name;
    int id;
    int pos_x;
    int pos_y;
};

#endif // STRUCTS_HPP