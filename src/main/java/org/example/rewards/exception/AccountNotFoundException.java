package org.example.rewards.exception;

/**
 *  Custom Exception thrown while processing eligibility checks. This is thrown if valid account no is not found
 */
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

