package org.codecraftlabs.mercury.crypto;

public class DigestException extends Exception {
    public DigestException(String message) {
        super(message);
    }

    public DigestException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
