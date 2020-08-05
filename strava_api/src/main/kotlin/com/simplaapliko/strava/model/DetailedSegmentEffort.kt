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

data class DetailedSegmentEffort(

    /**
     * The unique identifier of this effort
     */
    @SerializedName("id")
    val id: Long,

    /**
     * Resource state, indicates level of detail.
     * Possible values: 1 -> "meta", 2 -> "summary", 3 -> "detail"
     * @see com.simplaapliko.strava.model.ResourceState
     */
    @SerializedName("resource_state")
    var resourceState: Int,

    /**
     * The name of the segment on which this effort was performed
     */
    @SerializedName("name")
    val name: String,

    /**
     * An instance of MetaActivity.
     */
    @SerializedName("activity")
    val activity: MetaActivity,

    /**
     * An instance of MetaAthlete.
     */
    @SerializedName("athlete")
    val athlete: MetaAthlete,

    /**
     * The effort's elapsed time
     */
    @SerializedName("elapsed_time")
    val elapsedTime: Int,

    /**
     * The effort's moving time
     */
    @SerializedName("moving_time")
    val movingTime: Int,

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
     * The start index of this effort in its activity's stream
     */
    @SerializedName("start_index")
    val startIndex: Int,

    /**
     * The end index of this effort in its activity's stream
     */
    @SerializedName("end_index")
    val endIndex: Int,

    /**
     * The rank of the effort on the global leaderboard if it belongs in the top 10 at the time of upload
     */
    @SerializedName("kom_rank")
    val komRank: Int?,

    /**
     * The rank of the effort on the athlete's leaderboard if it belongs in the top 3 at the time of upload
     */
    @SerializedName("pr_rank")
    val prRank: Int?,

    /**
     * The effort's average cadence
     */
    @SerializedName("average_cadence")
    val averageCadence: Double?,

    /**
     * The average wattage of this effort
     */
    @SerializedName("average_watts")
    val averageWatts: Double?,

    /**
     * For riding efforts, whether the wattage was reported by a dedicated recording device
     */
    @SerializedName("device_watts")
    val deviceWatts: Boolean?,

    /**
     * The heart heart rate of the athlete during this effort
     */
    @SerializedName("average_heartrate")
    val averageHeartRate: Double?,

    /**
     * The maximum heart rate of the athlete during this effort
     */
    @SerializedName("max_heartrate")
    val maxHeartRate: Double?,

    @SerializedName("segment")
    val segment: SummarySegment?,

    /**
     * Whether this effort should be hidden when viewed within an activity
     */
    @SerializedName("hidden")
    val hidden: Boolean,

    @SerializedName("achievements")
    val achievements: List<Achievement>
)
