#pragma once
#ifndef STRUCTS_HPP
#define STRUCTS_HPP

#include <string>

struct Environment2D {
    int width;
    int height;
};

struct Agent {
    std::string name;
    int id;
    int pos_x;
    int pos_y;
};

#endif // STRUCTS_HPP