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

import com.simplaapliko.strava.gson.serializer.FrameTypeAdapter
import com.simplaapliko.strava.gson.serializer.FriendStateAdapter
import com.simplaapliko.strava.gson.serializer.MeasurementPreferenceAdapter
import com.simplaapliko.strava.gson.serializer.ResourceStateAdapter
import com.simplaapliko.strava.gson.serializer.SexAdapter
import com.simplaapliko.strava.gson.serializer.SportTypeAdapter
import com.simplaapliko.strava.model.FrameType
import com.simplaapliko.strava.model.FriendState
import com.simplaapliko.strava.model.MeasurementPreference
import com.simplaapliko.strava.model.ResourceState
import com.simplaapliko.strava.model.Sex
import com.simplaapliko.strava.model.SportType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.Date

object JsonUtils {

    fun moshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(Date::class.java, Rfc3339DateJsonAdapter())
                .add(FrameType::class.java, FrameTypeAdapter())
                .add(FriendState::class.java, FriendStateAdapter())
                .add(MeasurementPreference::class.java, MeasurementPreferenceAdapter())
                .add(ResourceState::class.java, ResourceStateAdapter())
                .add(Sex::class.java, SexAdapter())
                .add(SportType::class.java, SportTypeAdapter())
                .build()
    }
}
