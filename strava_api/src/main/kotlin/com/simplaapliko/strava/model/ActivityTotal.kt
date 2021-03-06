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

data class ActivityTotal(
    /**
     * The number of activities considered in this total.
     */
    @SerializedName("count")
    var count: Int,

    /**
     * The total distance covered by the considered activities.
     */
    @SerializedName("distance")
    var distance: Double,

    /**
     * The total moving time of the considered activities.
     */
    @SerializedName("moving_time")
    var movingTime: Int,

    /**
     * The total elapsed time of the considered activities.
     */
    @SerializedName("elapsed_time")
    var elapsedTime: Int,

    /**
     * The total elevation gain of the considered activities.
     */
    @SerializedName("elevation_gain")
    var elevationGain: Double,

    /**
     * The total number of achievements of the considered activities.
     */
    @SerializedName("achievement_count")
    var achievementCount: Int
)
