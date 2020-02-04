package org.example.rewards.service;

import org.example.interfaces.service.CheckEligibilityAPIInterface;

/**
 *
 */
public interface EligibilityCheckerServiceInterface {

    void setCheckEligibilityAPIInterface(CheckEligibilityAPIInterface checkEligibilityAPIInterface);

    boolean checkEligibility(String customerAccountNo) throws Exception;
}
