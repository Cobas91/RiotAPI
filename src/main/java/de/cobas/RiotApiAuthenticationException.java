package de.cobas;

public class RiotApiAuthenticationException extends RuntimeException {
    public RiotApiAuthenticationException() {
        super("Please set the APIToken to continue with Authenticated Requests. Use the setter on the Client");
    }
}
