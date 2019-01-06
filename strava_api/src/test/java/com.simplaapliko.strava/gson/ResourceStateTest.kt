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
import com.simplaapliko.strava.model.ResourceState
import org.junit.Test

class ResourceStateTest {

    @Test
    fun emptyResourceState_shouldBeConvertedToUnknown() {
        val json = "{}"

        val gear = GsonUtils.gson()
                .fromJson(json, DetailedGear::class.java)

        assertThat(gear.resourceState).isEqualTo(ResourceState.UNKNOWN)
    }

    @Test
    fun resourceState0_shouldBeConvertedToUnknown() {
        val json = """{"resource_state" : 0}"""

        val gear = GsonUtils.gson()
                .fromJson(json, DetailedGear::class.java)

        assertThat(gear.resourceState).isEqualTo(ResourceState.UNKNOWN)
    }

    @Test
    fun resourceState3_shouldBeConvertedToDetail() {
        val json = """{"resource_state" : 3}"""

        val gear = GsonUtils.gson()
                .fromJson(json, DetailedGear::class.java)

        assertThat(gear.resourceState).isEqualTo(ResourceState.DETAIL)
    }

    @Test
    fun resourceState5_shouldBeConvertedToUnknown() {
        val json = """{"resource_state" : 5}"""

        val gear = GsonUtils.gson()
                .fromJson(json, DetailedGear::class.java)

        assertThat(gear.resourceState).isEqualTo(ResourceState.UNKNOWN)
    }
}
