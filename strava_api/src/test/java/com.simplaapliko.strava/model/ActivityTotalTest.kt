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

class ActivityTotalTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val model = GsonUtils.gson()
                .fromJson(json, ActivityTotal::class.java)

        assertThat(model.count).isEqualTo(0)
        assertThat(model.distance).isEqualTo(0.0)
        assertThat(model.movingTime).isEqualTo(0)
        assertThat(model.elapsedTime).isEqualTo(0)
        assertThat(model.elevationGain).isEqualTo(0.0)
        assertThat(model.achievementCount).isEqualTo(0)
    }
}
