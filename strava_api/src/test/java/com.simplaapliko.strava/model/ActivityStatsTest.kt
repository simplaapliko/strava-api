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
import com.simplaapliko.strava.gson.JsonUtils
import org.junit.Test

class ActivityStatsTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val model = JsonUtils.moshi()
                .adapter(ActivityStats::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.biggestRideDistance).isEqualTo(0.0)
        assertThat(model.biggestClimbElevationGain).isEqualTo(0.0)
        assertThat(model.recentRideTotals).isNull()
        assertThat(model.recentRunTotals).isNull()
        assertThat(model.recentSwimTotals).isNull()
        assertThat(model.ytdRideTotals).isNull()
        assertThat(model.ytdRunTotals).isNull()
        assertThat(model.ytdSwimTotals).isNull()
        assertThat(model.allRideTotals).isNull()
        assertThat(model.allRunTotals).isNull()
        assertThat(model.allSwimTotals).isNull()
    }
}
