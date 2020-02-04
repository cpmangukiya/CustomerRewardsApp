package org.example.interfaces.service;

import org.example.interfaces.pojo.Eligibility;

/**
 * TODO: Add description
 */
public interface CheckEligibilityAPIInterface {

    Eligibility getDetailsByCustomerId(String customerAccountNo) throws Exception;

}
