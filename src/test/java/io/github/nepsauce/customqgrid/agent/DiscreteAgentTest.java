package io.github.nepsauce.customqgrid.agent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.nepsauce.customqgrid.core.AgentState;
import org.junit.jupiter.api.Test;

class DiscreteAgentTest {
    @Test
    void defaultAgentMatchesCppDefaults() {
        DiscreteAgent agent = new DiscreteAgent();

        assertEquals("agent", agent.getName());
        assertEquals(0, agent.getId());
        assertEquals(0, agent.getPosX());
        assertEquals(0, agent.getPosY());
    }

    @Test
    void constructorMapsIdentityAndPosition() {
        DiscreteAgent agent = new DiscreteAgent(7, "runner", 2, 3);

        assertEquals(7, agent.getId());
        assertEquals("runner", agent.getName());
        assertEquals(2, agent.getPosX());
        assertEquals(3, agent.getPosY());
    }

    @Test
    void placementAndStateApplyUpdateCoordinates() {
        DiscreteAgent agent = new DiscreteAgent();
        agent.placeAt(4, 5);

        assertEquals(4, agent.getPosX());
        assertEquals(5, agent.getPosY());

        agent.applyState(new AgentState("agent", 0, 9, 8));
        assertEquals(9, agent.getPosX());
        assertEquals(8, agent.getPosY());
    }
}
