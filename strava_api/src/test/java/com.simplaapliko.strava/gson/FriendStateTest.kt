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
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.FriendState
import org.junit.Test

class FriendStateTest {

    @Test
    fun emptyFriendState_shouldBeConvertedToUnknown() {
        val json = "{}"

        val model = GsonUtils.gson()
                .fromJson(json, Athlete::class.java)

        assertThat(model.friend).isEqualTo(FriendState.UNKNOWN)
        assertThat(model.follower).isEqualTo(FriendState.UNKNOWN)
    }

    @Test
    fun friendStateNull_shouldBeConvertedToUnknown() {
        val json = """{"friend" : null, "follower" : null}"""

        val model = GsonUtils.gson()
                .fromJson(json, Athlete::class.java)

        assertThat(model.friend).isEqualTo(FriendState.UNKNOWN)
        assertThat(model.follower).isEqualTo(FriendState.UNKNOWN)
    }

    @Test
    fun friendStatePending_shouldBeConvertedToPending() {
        val json = """{"friend" : "pending", "follower" : "pending"}"""

        val model = GsonUtils.gson()
                .fromJson(json, Athlete::class.java)

        assertThat(model.friend).isEqualTo(FriendState.PENDING)
        assertThat(model.follower).isEqualTo(FriendState.PENDING)
    }
}