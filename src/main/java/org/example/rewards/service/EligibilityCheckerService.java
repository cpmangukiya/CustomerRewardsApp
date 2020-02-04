package org.example.rewards.service;

import org.example.interfaces.pojo.Eligibility;
import org.example.interfaces.service.CheckEligibilityAPIInterface;
import org.example.rewards.exception.AccountNotFoundException;
import org.example.rewards.exception.TechnicalFailureException;

/**
 *
 */
public class EligibilityCheckerService implements EligibilityCheckerServiceInterface {

    private CheckEligibilityAPIInterface checkEligibilityAPIInterface;

    @Override
    public void setCheckEligibilityAPIInterface(CheckEligibilityAPIInterface checkEligibilityAPIInterface) {
        this.checkEligibilityAPIInterface = checkEligibilityAPIInterface;
    }

    @Override
    public boolean checkEligibility(String customerAccountNo) throws Exception {

        if(customerAccountNo == null) {
            return false;
        }

        Eligibility eligibility = checkEligibilityAPIInterface.getDetailsByCustomerId(customerAccountNo);

        if(eligibility == null) {
            return false;
        } else if(eligibility.isEligible()){
            return true;
        } else if(!eligibility.isEligible() && eligibility.getResponseCode() != null && "INVALID_ACCOUNT".equals(eligibility.getResponseCode())){
            throw new AccountNotFoundException("Customer Account not found for Account No "+customerAccountNo);
        } else if(!eligibility.isEligible() && eligibility.getResponseCode() != null && "SYSTEM_FAILURE".equals(eligibility.getResponseCode())){
            throw new TechnicalFailureException("Technical Failure occurred while checking eligibility for Account No"+customerAccountNo);
        } else {
            return false;
        }
    }
}
