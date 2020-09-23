package com.llajournade.myreddit.exception;

import org.springframework.mail.MailException;

public class SpringRedditException extends RuntimeException {

    public SpringRedditException(String exMessage, Exception e) {
        super(exMessage,e);
    }

    public SpringRedditException(String exMessage) {
        super(exMessage);
    }

}
