package com.sunrise.exception;

/**
 * 重复预约异常
 */
public class ReAppointException extends RuntimeException {
    public ReAppointException(String message) {
        super(message);
    }

    public ReAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
