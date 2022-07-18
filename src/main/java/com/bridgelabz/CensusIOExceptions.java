package com.bridgelabz;

public class CensusIOExceptions extends Exception {

    public CensusIOExceptions(String message) {
        super(message);
    }

    public enum exceptionType {
        NO_SUCH_FILE,
        INCORRECT_TYPE,
        DELIMITER_ISSUE,
        INVALID_HEADER
    }
}
