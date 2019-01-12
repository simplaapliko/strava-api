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

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.simplaapliko.strava.gson.serializer.FrameTypeSerializer
import com.simplaapliko.strava.gson.serializer.ResourceStateSerializer
import com.simplaapliko.strava.gson.serializer.SexTypeSerializer
import com.simplaapliko.strava.gson.serializer.SportTypeSerializer
import com.simplaapliko.strava.model.FrameType
import com.simplaapliko.strava.model.ResourceState
import com.simplaapliko.strava.model.Sex
import com.simplaapliko.strava.model.SportType

object GsonUtils {

    fun gson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(FrameType::class.java, FrameTypeSerializer())
                .registerTypeAdapter(ResourceState::class.java, ResourceStateSerializer())
                .registerTypeAdapter(Sex::class.java, SexTypeSerializer())
                .registerTypeAdapter(SportType::class.java, SportTypeSerializer())
                .create()
    }
}
