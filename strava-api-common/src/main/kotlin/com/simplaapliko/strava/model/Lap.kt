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

data class Lap(

    /**
     * The unique identifier of this lap
     */
    @SerializedName("id")
    val id: Long,

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
     * The lap's average cadence
     */
    @SerializedName("average_cadence")
    val averageCadence: Double,

    /**
     * The lap's average speed
     */
    @SerializedName("average_speed")
    val averageSpeed: Double,

    /**
     * The lap's distance, in meters
     */
    @SerializedName("distance")
    val distance: Double,

    /**
     * The lap's elapsed time, in seconds
     */
    @SerializedName("elapsed_time")
    val elapsedTime: Int,

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
     * The index of this lap in the activity it belongs to
     */
    @SerializedName("lap_index")
    val lapIndex: Int,

    /**
     * The maximum speed of this lat, in meters per second
     */
    @SerializedName("max_speed")
    val maxSpeed: Double,

    /**
     * The lap's moving time, in seconds
     */
    @SerializedName("moving_time")
    val movingTime: Int,

    /**
     * The name of the lap
     */
    @SerializedName("name")
    val name: String,

    /**
     * The athlete's pace zone during this lap
     */
    @SerializedName("pace_zone")
    val paceZone: Int,

    /**
     * An instance of integer.
     */
    @SerializedName("split")
    val split: Int,

    /**
     * The time at which the lap was started.
     */
    @SerializedName("start_date")
    val startDate: String,

    /**
     * The time at which the lap was started in the local timezone.
     */
    @SerializedName("start_date_local")
    val startDateLocal: String,

    /**
     * The elevation gain of this lap, in meters
     */
    @SerializedName("total_elevation_gain")
    val totalElevationGain: Double
)
