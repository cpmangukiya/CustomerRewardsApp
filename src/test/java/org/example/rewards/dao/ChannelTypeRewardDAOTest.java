package org.example.rewards.dao;

import org.example.rewards.pojo.Reward;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test data layer which provides channels and rewards details
 */
public class ChannelTypeRewardDAOTest {

    private ChannelTypeRewardDAOInterface channelTypeRewardDAOInterface;

    public ChannelTypeRewardDAOTest() {
        channelTypeRewardDAOInterface = new ChannelTypeRewardDAO();
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType1() {
        Reward reward = channelTypeRewardDAOInterface.findReward("SPORTS");
        assertNotNull(reward);
        assertEquals("CMP_LEAGUE_FINAL_TKT", reward.getRewardCode());
        assertEquals("Champions League Final Ticket", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType2() {
        Reward reward = channelTypeRewardDAOInterface.findReward("SKITS");
        assertNotNull(reward);
        assertEquals("NO_REWARD", reward.getRewardCode());
        assertEquals("No Reward", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType3() {
        Reward reward = channelTypeRewardDAOInterface.findReward("MUSIC");
        assertNotNull(reward);
        assertEquals("KRK_PRO_MIC", reward.getRewardCode());
        assertEquals("Karaoke PRO microphone", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType4() {
        Reward reward = channelTypeRewardDAOInterface.findReward("NEWS");
        assertNotNull(reward);
        assertEquals("NO_REWARD", reward.getRewardCode());
        assertEquals("No Reward", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType5() {
        Reward reward = channelTypeRewardDAOInterface.findReward("MOVIES");
        assertNotNull(reward);
        assertEquals("PIRATES_MOVIE_COLLECTION", reward.getRewardCode());
        assertEquals("Pirates of the caribbean movie collection", reward.getRewardDescription());
    }
}