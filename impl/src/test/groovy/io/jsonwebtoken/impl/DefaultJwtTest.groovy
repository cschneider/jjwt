/*
 * Copyright (C) 2014 jsonwebtoken.io
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
package io.jsonwebtoken.impl

import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import org.junit.Test

import static org.junit.Assert.assertEquals

class DefaultJwtTest {

    @Test
    void testToString() {
        String compact = Jwts.builder().setHeaderParam('foo', 'bar').setAudience('jsmith').compact();
        Jwt jwt = Jwts.parser().parseClaimsJwt(compact);
        assertEquals 'header={foo=bar, alg=none},body={aud=jsmith}', jwt.toString()
    }

}
