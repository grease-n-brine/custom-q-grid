package io.github.nepsauce.customqgrid.agent;

import io.github.nepsauce.customqgrid.core.AgentState;

public final class DiscreteAgent implements Agent {
    private AgentState state;

    public DiscreteAgent() {
        this.state = new AgentState("agent", 0, 0, 0);
    }

    public DiscreteAgent(int id, String name, int posX, int posY) {
        this.state = new AgentState(name, id, posX, posY);
    }

    @Override
    public int getId() {
        return state.id();
    }

    @Override
    public String getName() {
        return state.name();
    }

    @Override
    public int getPosX() {
        return state.posX();
    }

    @Override
    public int getPosY() {
        return state.posY();
    }

    @Override
    public AgentState getState() {
        return state;
    }

    public void placeAt(int posX, int posY) {
        setState(new AgentState(state.name(), state.id(), posX, posY));
    }

    public void applyState(AgentState newState) {
        setState(newState);
    }

    private void setState(AgentState newState) {
        this.state = newState;
    }
}
