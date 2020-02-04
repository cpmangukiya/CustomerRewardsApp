package org.example.rewards.pojo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test Reward POJO
 */
public class RewardTest {

    /**
     * Validate Reward class using constructor based instantiation
     */
    @Test
    public void shouldValidateConstructorAndGetters() {
        Reward reward = new Reward("CMP_LEAGUE_FINAL_TKT", "Champions League Final Ticket");
        assertEquals("CMP_LEAGUE_FINAL_TKT", reward.getRewardCode());
        assertEquals("Champions League Final Ticket", reward.getRewardDescription());
    }

    /**
     * Validate overridden equals Method
     */
    @Test
    public void shouldValidateEquals() {
        Reward rewardOne = new Reward("CMP_LEAGUE_FINAL_TKT", "Champions League Final Ticket");
        Reward rewardTwo = new Reward("CMP_LEAGUE_FINAL_TKT", "Champions League Final Ticket");
        assertEquals(rewardOne, rewardTwo);
        Reward rewardThree = new Reward("NO_REWARD", "No Reward");
        assertNotEquals(rewardOne, rewardThree);
    }

}
