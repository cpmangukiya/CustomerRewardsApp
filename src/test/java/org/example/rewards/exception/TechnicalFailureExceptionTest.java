package org.example.rewards.exception;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.example.rewards.exception.TechnicalFailureException;

/**
 * Test for custom TechnicalFailureException
 */
public class TechnicalFailureExceptionTest {

    /**
     * Validate TechnicalFailureException class using constructor based instantiation
     */
    @Test
    public void shouldValidateConstructorAndGetters() {
        TechnicalFailureException technicalFailureException = new TechnicalFailureException("Account details not found during eligibility check!");
        assertEquals("Account details not found during eligibility check!", technicalFailureException.getMessage());
    }

    /**
     * Validate that TechnicalFailureException is a type of RuntimeException
     */
    @Test
    public void shouldValidateThatItIsThrowable() {
        TechnicalFailureException technicalFailureException = new TechnicalFailureException("Account details not found during eligibility check!");
        assertThat(technicalFailureException, instanceOf(RuntimeException.class));
    }

}
