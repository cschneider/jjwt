package io.jsonwebtoken.security;

import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

/**
 * Implementations of KeyGenerator will generate {@link SecretKey} based for a given {@link SignatureAlgorithm}.
 *
 * @since 0.11.0
 */
public interface KeyGenerator {

    /**
     * Returns true if the SignatureAlgorithm {@code alg} is supported by this KeyGenerator.
     * @param alg SignatureAlgorithm to check
     * @return Returns true if the SignatureAlgorithm {@code alg} is supported by this KeyGenerator.
     */
    boolean supports(SignatureAlgorithm alg);

    /**
     * Generates a new secure-random secret key of a length suitable for creating and verifying HMAC signatures
     * according to the specified {@code SignatureAlgorithm}.
     *
     * @param alg the desired signature algorithm
     * @return a new secure-random secret key of a length suitable for creating and verifying HMAC signatures according
     * to the specified {@code SignatureAlgorithm}.
     */
    SecretKey generateKey(SignatureAlgorithm alg);
}
