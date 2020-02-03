package org.example.interfaces.pojo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.example.interfaces.pojo.Eligibility;

/**
 * Test Eligibility POJO
 */
public class EligibilityTest {

    /**
     * Validate Eligibility class using constructor based instantiation
     */
    @Test
    public void shouldValidateConstructorAndGetters() {
        Eligibility eligibility = new Eligibility("ACT001", "ELIGIBLE", true);
        assertEquals("ACT001", eligibility.getCustomerAccountNo());
        assertEquals("ELIGIBLE", eligibility.getResponseCode());
        assertEquals(true, eligibility.isEligible());
    }
}
