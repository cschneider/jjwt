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
package io.jsonwebtoken.lang

import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

class MapsTest {

    @Test
    void testSingleMapOf() {
        assertThat Maps.of("aKey", "aValue"), is([aKey: "aValue"])
    }

    @Test
    void testTwoMapOf() {
        assertThat Maps.of("aKey1", "aValue1", "aKey2", "aValue2"),
                is([aKey1: "aValue1", aKey2: "aValue2"])
    }

    @Test
    void testThreeMapOf() {
        assertThat Maps.of("aKey1", "aValue1", "aKey2", "aValue2", "aKey3", "aValue3"),
                is([aKey1: "aValue1", aKey2: "aValue2", aKey3: "aValue3"])
    }

    @Test
    void testFourMapOf() {
        assertThat Maps.of("aKey1", "aValue1", "aKey2", "aValue2", "aKey3", "aValue3", "aKey4", "aValue4"),
                is([aKey1: "aValue1", aKey2: "aValue2", aKey3: "aValue3", aKey4: "aValue4"])
    }
}
