package io.jsonwebtoken.lang;

import io.jsonwebtoken.JwtException;

/**
 * Exception indicating that no implementation of an jjwt-api SPI was found on the classpath.
 */
public class ImplementationNotFoundException extends JwtException {

    private static final String DEFAULT_NOT_FOUND_MESSAGE = "No implementation of %s found on the classpath. Make sure to include an implementation of jjwt-api.";
    private static final String NAMED_NOT_FOUND_MESSAGE = "No implementation of %s:%s found on the classpath. Make sure to include an implementation of jjwt-api.";

    public ImplementationNotFoundException(final Class klass) {
        super(String.format(DEFAULT_NOT_FOUND_MESSAGE, klass));
    }

    public ImplementationNotFoundException(final Class klass, String name) {
        super(String.format(NAMED_NOT_FOUND_MESSAGE, klass, name));
    }
}
