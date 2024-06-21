package com.sbagoudou.yatzy.exception;

import java.text.MessageFormat;

public class YatzyException extends RuntimeException {

    public YatzyException(String message) {
        super(message);
    }

    public YatzyException(String message, Object... params) {
        super(MessageFormat.format(message, params));
    }
}
