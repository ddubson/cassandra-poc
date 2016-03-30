package com.ddubson.filmfox.exception;

/**
 * Author: ddubson
 */
public class SearchResultsNotProcessedException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public SearchResultsNotProcessedException(String msg) {
        super(msg);
    }
}
