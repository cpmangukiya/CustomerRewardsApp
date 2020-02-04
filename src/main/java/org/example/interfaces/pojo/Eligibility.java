package org.example.interfaces.pojo;

/**
 * TODO: Add description
 */
public class Eligibility {

    private String customerAccountNo;
    private String responseCode;
    private boolean eligible;

    public Eligibility(String customerAccountNo, String responseCode, boolean eligible) {
        this.customerAccountNo = customerAccountNo;
        this.responseCode = responseCode;
        this.eligible = eligible;
    }

    public String getCustomerAccountNo() {
        return customerAccountNo;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public boolean isEligible() {
        return eligible;
    }
}
