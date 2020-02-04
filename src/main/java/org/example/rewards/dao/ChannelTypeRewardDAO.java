package org.example.rewards.dao;

import org.example.rewards.pojo.ChannelType;
import org.example.rewards.pojo.Reward;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ChannelTypeRewardDAO implements ChannelTypeRewardDAOInterface {

    private Map<ChannelType, Reward> channelTypeRewardMap;

    public ChannelTypeRewardDAO() {
        channelTypeRewardMap = new HashMap<ChannelType, Reward>();
        channelTypeRewardMap.put(new ChannelType("SPORTS"), new Reward("CMP_LEAGUE_FINAL_TKT","Champions League Final Ticket"));
        channelTypeRewardMap.put(new ChannelType("SKITS"), new Reward("NO_REWARD","No Reward"));
        channelTypeRewardMap.put(new ChannelType("MUSIC"), new Reward("KRK_PRO_MIC","Karaoke PRO microphone"));
        channelTypeRewardMap.put(new ChannelType("NEWS"), new Reward("NO_REWARD","No Reward"));
        channelTypeRewardMap.put(new ChannelType("MOVIES"), new Reward("PIRATES_MOVIE_COLLECTION","Pirates of the caribbean movie collection"));
    }

    @Override
    public Reward findReward(String channelTypeName) {
        Reward reward = null;
        if(channelTypeName != null) {
            reward = channelTypeRewardMap.get(new ChannelType(channelTypeName));
        }
        return reward;
    }
}
