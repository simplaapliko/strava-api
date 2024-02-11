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

data class Split(

    /**
     * The average speed of this split, in meters per second
     */
    @SerializedName("average_speed")
    val average_speed: Double,

    /**
     * The distance of this split, in meters
     */
    @SerializedName("distance")
    val distance: Double,

    /**
     * The elapsed time of this split, in seconds
     */
    @SerializedName("elapsed_time")
    val elapsedTime: Int,

    /**
     * The elevation difference of this split, in meters
     */
    @SerializedName("elevation_difference")
    val elevationDifference: Double,

    /**
     * The pacing zone of this split
     */
    @SerializedName("pace_zone")
    val paceZone: Int,

    /**
     * The moving time of this split, in seconds
     */
    @SerializedName("moving_time")
    val movingTime: Int,

    /**
     * N/A
     */
    @SerializedName("split")
    val split: Int
)
