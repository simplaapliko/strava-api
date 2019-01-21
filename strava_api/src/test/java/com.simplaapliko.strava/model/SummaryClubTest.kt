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
import com.simplaapliko.strava.json.JsonUtils
import org.junit.Test

class SummaryClubTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val model = JsonUtils.moshi()
                .adapter(SummaryClub::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.id).isEqualTo(0)
        assertThat(model.resourceState).isEqualTo(ResourceState.UNKNOWN)
        assertThat(model.name).isEmpty()
        assertThat(model.profileMedium).isEmpty()
        assertThat(model.coverPhoto).isEmpty()
        assertThat(model.coverPhotoSmall).isEmpty()
        assertThat(model.sportType).isEqualTo(SportType.UNKNOWN)
        assertThat(model.city).isEmpty()
        assertThat(model.state).isEmpty()
        assertThat(model.country).isEmpty()
        assertThat(model.private).isFalse()
        assertThat(model.memberCount).isEqualTo(0)
        assertThat(model.featured).isFalse()
        assertThat(model.verified).isFalse()
        assertThat(model.url).isEmpty()
    }
}
