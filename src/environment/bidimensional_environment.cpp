#include "bidimensional_environment.hpp"

BidimensionalEnvironment::BidimensionalEnvironment(int width, int height) {
    env.width = width;
    env.height = height;
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

void BidimensionalEnvironment::setEnvironment(const Environment2D& newEnv) {
    env = newEnv;
}