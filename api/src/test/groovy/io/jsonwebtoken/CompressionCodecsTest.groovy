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
package io.jsonwebtoken

import io.jsonwebtoken.lang.Services
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

import static org.easymock.EasyMock.expect
import static org.junit.Assert.assertSame
import static org.powermock.api.easymock.PowerMock.*

@RunWith(PowerMockRunner.class)
@PrepareForTest([Services, CompressionCodecs])
class CompressionCodecsTest {

    @Test
    void testStatics() {

        mockStatic(Services)

        def deflate = createMock(CompressionCodec)
        def gzip = createMock(CompressionCodec)

        // any times, these are loaded from a loop, getAlgorithmName could be at most twice
        expect(deflate.getAlgorithmName()).andReturn("DEF").times(1, 2)
        expect(gzip.getAlgorithmName()).andReturn("GZIP").times(1, 2)
        expect(Services.loadAllAvailableImplementations(CompressionCodec)).andReturn([gzip, deflate])

        replayAll Services, deflate, gzip

        assertSame deflate, CompressionCodecs.DEFLATE
        assertSame gzip, CompressionCodecs.GZIP

        verify Services, deflate, gzip

        //test coverage for private constructor:
        new CompressionCodecs()
    }
}
