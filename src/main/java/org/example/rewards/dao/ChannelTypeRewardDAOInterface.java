package org.example.rewards.dao;

import org.example.rewards.pojo.Reward;

/**
 *
 */
public interface ChannelTypeRewardDAOInterface {
    Reward findReward(String channelTypeName);
}
