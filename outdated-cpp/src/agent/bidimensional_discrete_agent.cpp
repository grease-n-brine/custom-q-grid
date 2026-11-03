#include "bidimensional_discrete_agent.hpp"

DiscreteAgent::DiscreteAgent() : agent{"agent", 0, 0, 0} {}

DiscreteAgent::DiscreteAgent(int id, std::string name, int posX, int posY) {
    agent.id = id;
    agent.name = name;
    agent.pos_x = posX;
    agent.pos_y = posY;
}

int DiscreteAgent::getId() const {
    return agent.id;
}

std::string DiscreteAgent::getName() const {
    return agent.name;
}

int DiscreteAgent::getPosX() const {
    return agent.pos_x;
}

int DiscreteAgent::getPosY() const {
    return agent.pos_y;
}

Agent DiscreteAgent::getAgent() const {
    return agent;
}

void DiscreteAgent::setAgent(const Agent& newAgent) {
    agent = newAgent;
}
