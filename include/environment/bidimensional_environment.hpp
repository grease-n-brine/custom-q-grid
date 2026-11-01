#ifndef BIDIMENSIONAL_ENVIRONMENT_HPP
#define BIDIMENSIONAL_ENVIRONMENT_HPP

#include "structs.hpp"

class BidimensionalEnvironment {
    Environment2D env;

    public:
    BidimensionalEnvironment(int width, int height); 

    int getWidth() const;
    int getHeight() const;

    Environment2D getEnvironment() const;

    private:
        void setEnvironment(const Environment2D& newEnv);
};

#endif // BIDIMENSIONAL_ENVIRONMENT_HPP