package org.example.rewards.service;

import org.example.rewards.dao.ChannelTypeRewardDAOInterface;
import org.example.rewards.pojo.ChannelType;
import org.example.rewards.pojo.Reward;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public interface CustomerRewardServiceInterface {

    void setEligibilityCheckerServiceInterface(EligibilityCheckerServiceInterface eligibilityCheckerServiceInterface);

    void setChannelTypeRewardDAOInterface(ChannelTypeRewardDAOInterface channelTypeRewardDAOInterface);

    ArrayList<Reward> fetchRewards(String customerAccountNo, HashSet<ChannelType> channelTypes);
}

