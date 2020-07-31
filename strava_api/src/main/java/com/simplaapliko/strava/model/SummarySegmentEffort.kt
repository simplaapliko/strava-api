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

data class SummarySegmentEffort(

    /**
     * The unique identifier of this effort
     */
    @SerializedName("id")
    val id: Long,

    /**
     * The unique identifier of the activity related to this effort
     */
    @SerializedName("activity_id")
    val activityId: Long,

    /**
     * The effort's elapsed time
     */
    @SerializedName("elapsed_time")
    val elapsedTime: Int,

    /**
     * The time at which the effort was started.
     */
    @SerializedName("start_date")
    val startDate: String,

    /**
     * The time at which the effort was started in the local timezone.
     */
    @SerializedName("start_date_local")
    val startDateLocal: String,

    /**
     * The effort's distance in meters
     */
    @SerializedName("distance")
    val distance: Double,

    /**
     * Whether this effort is the current best on the leaderboard
     */
    @SerializedName("is_kom")
    val isKom: Boolean
)
