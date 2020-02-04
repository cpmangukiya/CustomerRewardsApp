package org.example.rewards.pojo;

import java.util.Objects;

/**
 *
 */
public class Reward {

    private String rewardCode;
    private String rewardDescription;

    public Reward(String rewardCode, String rewardDescription) {
        this.rewardCode = rewardCode;
        this.rewardDescription = rewardDescription;
    }

    public String getRewardCode() {
        return this.rewardCode;
    }

    public String getRewardDescription() {
        return this.rewardDescription;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) o;
        return Objects.equals(rewardCode, reward.rewardCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardCode);
    }
}
