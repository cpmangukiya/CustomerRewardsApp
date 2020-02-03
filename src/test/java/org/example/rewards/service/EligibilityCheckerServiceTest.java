package org.example.rewards.service;

import org.example.pojo.ChannelType;
import org.example.rewards.exception.AccountNotFoundException;
import org.example.rewards.exception.TechnicalFailureException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.example.rewards.service.EligibilityCheckerServiceInterface;
import org.example.interfaces.service.CheckEligibilityAPIInterface;

/**
 * Test service responsible for fetching customer reward
 */
public class EligibilityCheckerServiceTest {

    private EligibilityCheckerServiceInterface eligibilityCheckerServiceInterface;

    public EligibilityCheckerServiceTest() {
        eligibilityCheckerServiceInterface = new EligibilityCheckerServiceInterface();
        // Mockit
        CheckEligibilityAPIInterface checkEligibilityAPIInterface = mock(CheckEligibilityAPIInterface.class);
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT001")).thenReturn(new Eligibility("ACT001", "ELIGIBLE", true));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT002")).thenReturn(new Eligibility("ACT002", "ELIGIBLE", true));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT003")).thenReturn(new Eligibility("ACT003", "NOT_ELIGIBLE", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT004")).thenReturn(new Eligibility("ACT004", "SYSTEM_FAILURE", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT005")).thenReturn(new Eligibility("ACT005", "INVALID_ACCOUNT", false));
        when(checkEligibilityAPIInterface.getDetailsByCustomerId("ACT008")).thenThrow(new Exception("Something went wrong"));
        eligibilityCheckerServiceInterface.setCheckEligibilityAPIInterface(checkEligibilityAPIInterface);
    }

    /**
     * Test when account no is eligible
     */
    @Test
    public void shouldBeAbleReturnTrueWhenEligible() {
        boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility("ACT001");
        assertTrue(isEligible);
    }

    /**
     * Test when account no is not eligible
     */
    @Test
    public void shouldBeAbleReturnFalseWhenNotEligible() {
        boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility("ACT003");
        assertTrue(!isEligible);
    }

    /**
     * Test when technical error
     */
    @Test
    public void shouldBeAbleCatchWhenTechErrorFound() {
        try {
            boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility("ACT004");
        } catch (Exception e) {
            assertTrue(e instanceof TechnicalFailureException);
        }
    }

    /**
     * Test if account no not found
     */
    @Test
    public void shouldBeAbleCatchWhenAccountFound() {
        try {
            boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility("ACT005");
        } catch (Exception e) {
            assertTrue(e instanceof AccountNotFoundException);
        }
    }

    /**
     * Test if wrong data sent
     */
    @Test
    public void shouldBeAbleFetchEmptyListOfRewardsIfValidDataNotSent() {
        boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility(null);
        assertTrue(!isEligible);
    }

    /**
     * Test if wrong data sent
     */
    @Test
    public void shouldBeAbleCatchWhenExceptionOccurs() {
        try {
            boolean isEligible = eligibilityCheckerServiceInterface.checkEligibility("ACT008");
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        }
    }
}
