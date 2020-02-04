package org.example.interfaces.service;

import org.example.interfaces.pojo.Eligibility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Test eligibility API interface
 */
@RunWith(Parameterized.class)
public class CheckEligibilityAPIInterfaceTest {

    public CheckEligibilityAPIInterface checkEligibilityAPIInterface;

    public CheckEligibilityAPIInterfaceTest(CheckEligibilityAPIInterface checkEligibilityAPIInterface) {
        this.checkEligibilityAPIInterface = checkEligibilityAPIInterface;
    }

    /**
     * Method to test interface method 1
     */
    @Test
    public final void shouldBeAbleToCallInterfaceMethod1() throws Exception {
        Eligibility eligibility = checkEligibilityAPIInterface.getDetailsByCustomerId("ACT001");
        assertNotNull(eligibility);
        assertEquals("ACT001", eligibility.getCustomerAccountNo());
        assertEquals("ELIGIBLE", eligibility.getResponseCode());
        assertEquals(true, eligibility.isEligible());
    }

    /**
     * Method to test interface method 2
     */
    @Test
    public final void shouldBeAbleToCallInterfaceMethod2() throws Exception {
        Eligibility eligibility = checkEligibilityAPIInterface.getDetailsByCustomerId("ACT002");
        assertNotNull(eligibility);
        assertEquals("ACT002", eligibility.getCustomerAccountNo());
        assertEquals("ELIGIBLE", eligibility.getResponseCode());
        assertEquals(true, eligibility.isEligible());
    }

    /**
     * Method to test interface method 3
     */
    @Test
    public final void shouldBeAbleToCallInterfaceMethod3() throws Exception {
        Eligibility eligibility = checkEligibilityAPIInterface.getDetailsByCustomerId("ACT003");
        assertNull(eligibility);
    }

    /**
     * Data which returns new interface object to be tested
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
            new Object[]{ new CheckEligibilityAPIInterface(){
                public Eligibility getDetailsByCustomerId(String customerAccountNo) {
                    if(customerAccountNo.equals("ACT001")){
                        return new Eligibility("ACT001", "ELIGIBLE", true);
                    } else if (customerAccountNo.equals("ACT002")) {
                        return new Eligibility("ACT002", "ELIGIBLE", true);
                    } else {
                        return null;
                    }
                }
            }},
            new Object[]{ new CheckEligibilityAPIInterface(){
                public Eligibility getDetailsByCustomerId(String customerAccountNo) {
                    if(customerAccountNo.equals("ACT001")){
                        return new Eligibility("ACT001", "ELIGIBLE", true);
                    } else if (customerAccountNo.equals("ACT002")) {
                        return new Eligibility("ACT002", "ELIGIBLE", true);
                    } else {
                        return null;
                    }
                }
            }}
        );
    }
}
