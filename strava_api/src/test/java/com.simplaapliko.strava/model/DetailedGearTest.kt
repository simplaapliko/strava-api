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

package com.simplaapliko.strava.model

import com.google.common.truth.Truth.assertThat
import com.simplaapliko.strava.gson.GsonUtils
import org.junit.Test

class DetailedGearTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val gear = GsonUtils.gson()
                .fromJson(json, DetailedGear::class.java)

        assertThat(gear.id).isEmpty()
        assertThat(gear.resourceState).isEqualTo(ResourceState.UNKNOWN)
        assertThat(gear.primary).isFalse()
        assertThat(gear.name).isEmpty()
        assertThat(gear.distance).isZero()
        assertThat(gear.brandName).isEmpty()
        assertThat(gear.modelName).isEmpty()
        assertThat(gear.frameType).isEqualTo(FrameType.UNKNOWN)
        assertThat(gear.description).isEmpty()
    }
}
