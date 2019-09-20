package io.jsonwebtoken.security;

import io.jsonwebtoken.SignatureAlgorithm;

import java.security.KeyPair;

/**
 * Implementations of KeyGenerator will generate {@link KeyPair} based for a given {@link SignatureAlgorithm}.
 *
 * @since 0.11.0
 */
public interface KeyPairGenerator {

    /**
     * Returns true if the SignatureAlgorithm {@code alg} is supported by this KeyGenerator.
     * @param alg SignatureAlgorithm to check
     * @return Returns true if the SignatureAlgorithm {@code alg} is supported by this KeyGenerator.
     */
    boolean supports(SignatureAlgorithm alg);

    /**
     * Generates a new secure-random key pair of sufficient strength for the specified {@link SignatureAlgorithm} using
     * JJWT's default SecureRandom instance.
     *
     * @param alg the algorithm indicating strength
     * @return a new secure-randomly generated key pair of sufficient strength for the specified {@link
     * SignatureAlgorithm}.
     */
    KeyPair generateKeyPair(SignatureAlgorithm alg);
}
