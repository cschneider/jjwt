/*
 * Copyright (C) 2019 jsonwebtoken.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jsonwebtoken.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to help with the manipulation of working with Maps.
 * @since 0.11.0
 */
public final class Maps {

    private Maps() {} //prevent instantiation

    /**
     * Creates a map with a single entry.
     * @param key1 the maps key
     * @param value1 the maps value
     * @param <K> the maps key type
     * @param <V> the maps value type
     * @return an unmodifiable map with a single entry.
     */
    public static <K, V> Map<K, V> of(K key1, V value1) {
        HashMap<K, V> result = new HashMap<>(capacity(1));
        result.put(key1, value1);
        return Collections.unmodifiableMap(result);
    }

    /**
     * Creates a map with two entries.
     * @param key1 the maps key
     * @param value1 the maps value
     * @param <K> the maps key type
     * @param <V> the maps value type
     * @return an unmodifiable map with two entries.
     */
    public static <K, V> Map<K, V> of(K key1, V value1, K key2, V value2) {
        HashMap<K, V> result = new HashMap<>(capacity(2));
        result.put(key1, value1);
        result.put(key2, value2);
        return Collections.unmodifiableMap(result);
    }

    /**
     * Creates a map with three entries.
     * @param key1 the maps key
     * @param value1 the maps value
     * @param <K> the maps key type
     * @param <V> the maps value type
     * @return an unmodifiable map with three entries.
     */
    public static <K, V> Map<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3) {
        HashMap<K, V> result = new HashMap<>(capacity(3));
        result.put(key1, value1);
        result.put(key2, value2);
        result.put(key3, value3);
        return Collections.unmodifiableMap(result);
    }

    /**
     * Creates a map with four entries.
     * @param key1 the maps key
     * @param value1 the maps value
     * @param <K> the maps key type
     * @param <V> the maps value type
     * @return an unmodifiable map with four entries.
     */
    public static <K, V> Map<K, V> of(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        HashMap<K, V> result = new HashMap<>(capacity(4));
        result.put(key1, value1);
        result.put(key2, value2);
        result.put(key3, value3);
        result.put(key4, value4);
        return Collections.unmodifiableMap(result);
    }

    /**
     * Returns a capacity that is sufficient to keep the map from being resized as long as it grows no
     * larger than expectedSize and the load factor is ≥ its default (0.75).
     *
     * <p> Simplified version of capacity calculation from <a href="https://github.com/google/guava/blob/aa73da81be1c3dfd41b10ea6318970d279559b1c/guava/src/com/google/common/collect/Maps.java#L325-L337">Guava</a>
     */
    private static int capacity(int expectedSize) {
        // This is the calculation used in JDK8 to resize when a putAll
        // happens; it seems to be the most conservative calculation we
        // can make.  0.75 is the default load factor.
        return (int) ((float) expectedSize / 0.75F + 1.0F);
    }
}
