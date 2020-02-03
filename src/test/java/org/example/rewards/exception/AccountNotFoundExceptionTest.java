package org.example.rewards.exception;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.example.rewards.exception.AccountNotFoundException;

/**
 * Test for custom AccountNotFoundException
 */
public class AccountNotFoundExceptionTest {

    /**
     * Validate AccountNotFoundException class using constructor based instantiation
     */
    @Test
    public void shouldValidateConstructorAndGetters() {
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account details not found during eligibility check!");
        assertEquals("Account details not found during eligibility check!", accountNotFoundException.getMessage());
    }

    /**
     * Validate AccountNotFoundException is  a type of RuntimeException
     */
    @Test
    public void shouldValidateThatItIsThrowable() {
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account details not found during eligibility check!");
        assertThat(accountNotFoundException, instanceOf(RuntimeException.class));
    }

}
