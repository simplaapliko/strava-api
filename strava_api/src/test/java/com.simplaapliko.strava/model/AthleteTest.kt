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

class AthleteTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val model = JsonUtils.moshi()
                .adapter(Athlete::class.java)
                .fromJson(json)

        assertThat(model!!).isNotNull()
        assertThat(model.id).isEqualTo(0)
        assertThat(model.resourceState).isEqualTo(ResourceState.UNKNOWN)
        assertThat(model.firstName).isEqualTo("")
        assertThat(model.lastName).isEqualTo("")
        assertThat(model.profileMedium).isEqualTo("")
        assertThat(model.profile).isEqualTo("")
        assertThat(model.city).isEqualTo("")
        assertThat(model.state).isEqualTo("")
        assertThat(model.country).isEqualTo("")
        assertThat(model.sex).isEqualTo(Sex.UNKNOWN)
        assertThat(model.friend).isEqualTo(FriendState.UNKNOWN)
        assertThat(model.follower).isEqualTo(FriendState.UNKNOWN)
        assertThat(model.premium).isFalse()
        assertThat(model.summit).isFalse()
        assertThat(model.createdAt).isNull()
        assertThat(model.updatedAt).isNull()
        assertThat(model.followerCount).isEqualTo(0)
        assertThat(model.friendCount).isEqualTo(0)
        assertThat(model.mutualFriendCount).isEqualTo(0)
        assertThat(model.measurementPreference).isEqualTo(MeasurementPreference.UNKNOWN)
        assertThat(model.ftp).isEqualTo(0)
        assertThat(model.weight).isEqualTo(0.0)
        assertThat(model.clubs).isEmpty()
        assertThat(model.bikes).isEmpty()
        assertThat(model.shoes).isEmpty()
    }
}
