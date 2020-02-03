package org.example.rewards.dao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.example.rewards.dao.ChannelTypeRewardDAOInterface;
import org.example.rewards.pojo.Reward;

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
    public void shouldReturnValidRewardForGivenChannelType() {
        Reward reward = channelTypeRewardDAOInterface.findReward("SPORTS");
        assertEquals("CMP_LEAGUE_FINAL_TKT", reward.getRewardCode());
        assertEquals("Champions League Final Ticket", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType() {
        Reward reward = channelTypeRewardDAOInterface.findReward("SKITS");
        assertEquals("NO_REWARD", reward.getRewardCode());
        assertEquals("No Reward", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType() {
        Reward reward = channelTypeRewardDAOInterface.findReward("MUSIC");
        assertEquals("KRK_PRO_MIC", reward.getRewardCode());
        assertEquals("Karaoke PRO microphone", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType() {
        Reward reward = channelTypeRewardDAOInterface.findReward("NEWS");
        assertEquals("NO_REWARD", reward.getRewardCode());
        assertEquals("No Reward", reward.getRewardDescription());
    }

    /**
     * Data set test
     */
    @Test
    public void shouldReturnValidRewardForGivenChannelType() {
        Reward reward = channelTypeRewardDAOInterface.findReward("MOVIES");
        assertEquals("PIRATES_MOVIE_COLLECTION", reward.getRewardCode());
        assertEquals("Pirates of the caribbean movie collection", reward.getRewardDescription());
    }
}