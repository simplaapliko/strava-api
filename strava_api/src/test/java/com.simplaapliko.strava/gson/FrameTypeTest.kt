/*
 * Copyright (C) 2018 Oleg Kan
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

package com.simplaapliko.strava.gson

import com.google.common.truth.Truth.assertThat
import com.simplaapliko.strava.model.DetailedGear
import com.simplaapliko.strava.model.FrameType
import org.junit.Test

class FrameTypeTest {

    @Test
    fun emptyFrameType_shouldBeConvertedToUnknown() {
        val json = "{}"

        val model = JsonUtils.moshi()
                .adapter(DetailedGear::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.frameType).isEqualTo(FrameType.UNKNOWN)
    }

    @Test
    fun nullFrameType_shouldBeConvertedToUnknown() {
        val json = """{"frame_type" : null}"""

        val model = JsonUtils.moshi()
                .adapter(DetailedGear::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.frameType).isEqualTo(FrameType.UNKNOWN)
    }

    @Test
    fun frameType0_shouldBeConvertedToUnknown() {
        val json = """{"frame_type" : 0}"""

        val model = JsonUtils.moshi()
                .adapter(DetailedGear::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.frameType).isEqualTo(FrameType.UNKNOWN)
    }

    @Test
    fun frameType3_shouldBeConvertedToRoadBike() {
        val json = """{"frame_type" : 3}"""

        val model = JsonUtils.moshi()
                .adapter(DetailedGear::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.frameType).isEqualTo(FrameType.ROAD)
    }

    @Test
    fun frameType5_shouldBeConvertedToUnknown() {
        val json = """{"frame_type" : 5}"""

        val model = JsonUtils.moshi()
                .adapter(DetailedGear::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.frameType).isEqualTo(FrameType.UNKNOWN)
    }
}
