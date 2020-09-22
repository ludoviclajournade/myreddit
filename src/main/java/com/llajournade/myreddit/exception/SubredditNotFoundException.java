package com.llajournade.myreddit.exception;

public class SubredditNotFoundException extends RuntimeException {
    public SubredditNotFoundException(String s) {
        super(s);
    }

    public SubredditNotFoundException(Exception e) {
        super(e);
    }
}
