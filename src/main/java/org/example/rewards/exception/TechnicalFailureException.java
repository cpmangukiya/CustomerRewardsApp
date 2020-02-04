package org.example.rewards.exception;

/**
 *  Custom Exception thrown while processing eligibility checks. This is thrown if technical error was observed by service
 */
public class TechnicalFailureException extends RuntimeException {

    public TechnicalFailureException(String errorMessage) {
        super(errorMessage);
    }

}