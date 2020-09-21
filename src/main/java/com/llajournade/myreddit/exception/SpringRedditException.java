package com.llajournade.myreddit.exception;

import org.springframework.mail.MailException;

public class SpringRedditException extends RuntimeException {

    public SpringRedditException(String exMessage, MailException e) {
        super(exMessage,e);
    }
}
