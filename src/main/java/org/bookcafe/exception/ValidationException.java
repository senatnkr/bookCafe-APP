package org.bookcafe.exception;
public class ValidationException extends RuntimeException{

    // Hata mesajını alan kurucu
    public ValidationException(String message) {
        super(message);
    }

    // Hata mesajını ve sebep olan hatayı alan kurucu
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }


}
