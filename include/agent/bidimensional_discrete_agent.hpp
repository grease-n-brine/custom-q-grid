#ifndef DISCRETE_AGENT_HPP
#define DISCRETE_AGENT_HPP

#include "structs.hpp"

class DiscreteAgent {
    Agent agent;

    public:
        DiscreteAgent();
        DiscreteAgent(int id, std::string name, int posX, int posY);

        int getId() const;
        std::string getName() const;
        int getPosX() const;
        int getPosY() const;
        Agent getAgent() const;

    private:
        void setAgent(const Agent& newAgent);
};

#endif // DISCRETE_AGENT_HPP
