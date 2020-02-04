package org.example.rewards.service;

import org.example.interfaces.pojo.Eligibility;
import org.example.interfaces.service.CheckEligibilityAPIInterface;
import org.example.rewards.dao.ChannelTypeRewardDAO;
import org.example.rewards.pojo.ChannelType;
import org.example.rewards.pojo.Reward;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Test service responsible for fetching customer reward
 */
public class CustomerRewardServiceTest {

    private CustomerRewardServiceInterface customerRewardServiceInterface;

    public CustomerRewardServiceTest() throws Exception {
        customerRewardServiceInterface = new CustomerRewardService();
        EligibilityCheckerServiceInterface eligibilityCheckerServiceInterface = new EligibilityCheckerService();

        // Mockit
        CheckEligibilityAPIInterface checkEligibilityAPIInterface = mock(CheckEligibilityAPIInterface.class);
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT001")).thenReturn(new Eligibility("ACT001", "ELIGIBLE", true));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT002")).thenReturn(new Eligibility("ACT002", "ELIGIBLE", true));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT003")).thenReturn(new Eligibility("ACT003", "NOT_ELIGIBLE", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT004")).thenReturn(new Eligibility("ACT004", "SYSTEM_FAILURE", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT005")).thenReturn(new Eligibility("ACT005", "INVALID_ACCOUNT", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT008")).thenThrow(new Exception("Something went wrong"));
        eligibilityCheckerServiceInterface.setCheckEligibilityAPIInterface(checkEligibilityAPIInterface);

        customerRewardServiceInterface.setEligibilityCheckerServiceInterface(eligibilityCheckerServiceInterface);
        customerRewardServiceInterface.setChannelTypeRewardDAOInterface(new ChannelTypeRewardDAO());
    }

    /**
     * Test when relevant rewards available for valid account no and subscriptions
     */
    @Test
    public void shouldBeAbleFetchListOfRewards() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        channelTypeSet.add(new ChannelType("SPORTS"));
        channelTypeSet.add(new ChannelType("SKITS"));
        channelTypeSet.add(new ChannelType("MOVIES"));
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT001", channelTypeSet);

        //Expected reward's list
        ArrayList<Reward> expectedRewardList = new ArrayList<Reward>();
        expectedRewardList.add(new Reward("CMP_LEAGUE_FINAL_TKT", "Champions League Final Ticket"));
        expectedRewardList.add(new Reward("PIRATES_MOVIE_COLLECTION", "Pirates of the caribbean movie collection"));

        assertTrue(expectedRewardList.size() == fetchedRewardList.size() &&
                fetchedRewardList.containsAll(expectedRewardList) && expectedRewardList.containsAll(fetchedRewardList));
    }

    /**
     * Test if no reward available for valid account no and subscriptions
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfNoMatchingSubs() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        channelTypeSet.add(new ChannelType("SKITS"));
        channelTypeSet.add(new ChannelType("NEWS"));
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT002", channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }

    /**
     * Test if account no not eligible
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfNotEligible() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        channelTypeSet.add(new ChannelType("SKITS"));
        channelTypeSet.add(new ChannelType("NEWS"));
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT003", channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }

    /**
     *  Test if technical error occurred in eligibility checking
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfTechError() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        channelTypeSet.add(new ChannelType("SKITS"));
        channelTypeSet.add(new ChannelType("MOVIES"));
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT004", channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }

    /**
     * Test if account no not found
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfAccountNotFound() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        channelTypeSet.add(new ChannelType("SKITS"));
        channelTypeSet.add(new ChannelType("MOVIES"));
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT005", channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }

    /**
     * Test if wrong data sent
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfValidDataNotSent() {
        HashSet<ChannelType> channelTypeSet = null;
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards(null, channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }

    /**
     * Test if wrong data sent
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfEmptyDataSent() {
        HashSet<ChannelType> channelTypeSet = new HashSet<ChannelType>();
        ArrayList<Reward> fetchedRewardList = customerRewardServiceInterface.fetchRewards("ACT006", channelTypeSet);

        assertTrue(fetchedRewardList.size() == 0);
    }
}
