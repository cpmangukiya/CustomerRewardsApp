package org.example.interfaces.service;

import org.example.interfaces.pojo.Eligibility;
import org.example.interfaces.service.CheckEligibilityAPIInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;

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
     * Method to test interface method
     */
    @Test
        public final void shouldBeAbleToCallInterfaceMethod() {
            Eligibility eligibility = checkEligibilityAPIInterface.getDetailsByCustomerId("ACT001");
            assertNotNull(eligibility);
            assertEquals("ACT001", eligibility.getCustomerAccountNo());
            assertEquals("ELIGIBLE", eligibility.getResponseCode());
            assertEquals(true, eligibility.isEligible());
        }

    /**
     * Data which returns new interface object to be tested
     * @return
     */
    @Parameterized.Parameters
        public static Collection<Object[]> instancesToTest() {
            return Arrays.asList(
                new Object[]{new CheckEligibilityAPIInterface(){
                    public Eligibility getDetailsByCustomerId(String customerAccountNo) {
                        Eligibility eligibility = new Eligibility("ACT001", "ELIGIBLE", true);
                        return eligibility;
                    }
                }}
            );
        }
    }
