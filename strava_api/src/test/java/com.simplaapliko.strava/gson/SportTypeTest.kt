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
import com.simplaapliko.strava.model.SportType
import com.simplaapliko.strava.model.SummaryClub
import org.junit.Test

class SportTypeTest {

    @Test
    fun emptyJson_sportTypeShouldBeConvertedToUnknown() {
        val json = "{}"

        val model = GsonUtils.gson()
                .fromJson(json, SummaryClub::class.java)

        assertThat(model.sportType).isEqualTo(SportType.UNKNOWN)
    }

    @Test
    fun emptySportType_shouldBeConvertedToUnknown() {
        val json = """{"sport_type" : ""}"""

        val model = GsonUtils.gson()
                .fromJson(json, SummaryClub::class.java)

        assertThat(model.sportType).isEqualTo(SportType.UNKNOWN)
    }

    @Test
    fun sportTypeCycling_shouldBeConvertedToCycling() {
        val json = """{"sport_type" : "cycling"}"""

        val model = GsonUtils.gson()
                .fromJson(json, SummaryClub::class.java)

        assertThat(model.sportType).isEqualTo(SportType.CYCLING)
    }

    @Test
    fun sportTypeUnknown_shouldBeConvertedToUnknown() {
        val json = """{"sport_type" : "unknown_type"}"""

        val model = GsonUtils.gson()
                .fromJson(json, SummaryClub::class.java)

        assertThat(model.sportType).isEqualTo(SportType.UNKNOWN)
    }
}