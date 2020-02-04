package org.example.rewards.service;

import org.example.rewards.dao.ChannelTypeRewardDAOInterface;
import org.example.rewards.exception.AccountNotFoundException;
import org.example.rewards.exception.TechnicalFailureException;
import org.example.rewards.pojo.ChannelType;
import org.example.rewards.pojo.Reward;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 */
public class CustomerRewardService implements CustomerRewardServiceInterface {

    private EligibilityCheckerServiceInterface eligibilityCheckerServiceInterface;
    private ChannelTypeRewardDAOInterface channelTypeRewardDAOInterface;

    @Override
    public void setEligibilityCheckerServiceInterface(EligibilityCheckerServiceInterface eligibilityCheckerServiceInterface) {
        this.eligibilityCheckerServiceInterface = eligibilityCheckerServiceInterface;
    }

    @Override
    public void setChannelTypeRewardDAOInterface(ChannelTypeRewardDAOInterface channelTypeRewardDAOInterface) {
        this.channelTypeRewardDAOInterface = channelTypeRewardDAOInterface;
    }

    @Override
    public ArrayList<Reward> fetchRewards(String customerAccountNo, HashSet<ChannelType> channelTypes) {
        ArrayList<Reward> rewards = new ArrayList<Reward>();
        try {
            boolean eligible = false;
            // Check if customer account is eligible for reward or not.
            if(customerAccountNo != null && channelTypes != null && channelTypes.size() > 0) {

                eligible = eligibilityCheckerServiceInterface.checkEligibility(customerAccountNo);

                if (eligible) {
                    for(ChannelType channelType : channelTypes){
                        Reward reward = channelTypeRewardDAOInterface.findReward(channelType.getName());
                        if(reward != null && !"NO_REWARD".equals(reward.getRewardCode())) {
                            rewards.add(reward);
                        }
                    }
                }
            }
        } catch (TechnicalFailureException e) {
            // Technical Failure occurred while checking eligibility
        } catch (AccountNotFoundException e) {
            // Account id requested is not existing one
            // TODO: Notify customer that account no is invalid
        } catch (Exception e){
            // Exception occurred while calculating rewards
        }
        return rewards;
    }

}
