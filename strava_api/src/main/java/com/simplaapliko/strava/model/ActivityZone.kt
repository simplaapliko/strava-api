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

import com.google.gson.annotations.SerializedName

data class ActivityZone(

    @SerializedName("score")
    val score: Int,

    @SerializedName("distribution_buckets")
    val distributionBuckets: List<TimedZoneRange>,

    /**
     * May take one of the following values: heartrate, power
     * @see com.simplaapliko.strava.model.ActivityZoneType
     */
    @SerializedName("type")
    val type: String,

    @SerializedName("sensor_based")
    val sensorBased: Boolean,

    @SerializedName("points")
    val points: Int,

    @SerializedName("custom_zones")
    val customZones: Boolean,

    @SerializedName("max")
    val max: Int
)
