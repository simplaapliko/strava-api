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

data class ActivityStats(
    /**
     * The longest distance ridden by the athlete.
     */
    @SerializedName("biggest_ride_distance")
    var biggestRideDistance: Double = 0.0,

    /**
     * The highest climb ridden by the athlete.
     */
    @SerializedName("biggest_climb_elevation_gain")
    var biggestClimbElevationGain: Double = 0.0,

    /**
     * The recent (last 4 weeks) ride stats for the athlete.
     */
    @SerializedName("recent_ride_totals")
    var recentRideTotals: ActivityTotal? = null,

    /**
     * The recent (last 4 weeks) run stats for the athlete.
     */
    @SerializedName("recent_run_totals")
    var recentRunTotals: ActivityTotal? = null,

    /**
     * The recent (last 4 weeks) swim stats for the athlete.
     */
    @SerializedName("recent_swim_totals")
    var recentSwimTotals: ActivityTotal? = null,

    /**
     * The year to date ride stats for the athlete.
     */
    @SerializedName("ytd_ride_totals")
    var ytdRideTotals: ActivityTotal? = null,

    /**
     * The year to date run stats for the athlete.
     */
    @SerializedName("ytd_run_totals")
    var ytdRunTotals: ActivityTotal? = null,

    /**
     * The year to date swim stats for the athlete.
     */
    @SerializedName("ytd_swim_totals")
    var ytdSwimTotals: ActivityTotal? = null,

    /**
     * The all time ride stats for the athlete.
     */
    @SerializedName("all_ride_totals")
    var allRideTotals: ActivityTotal? = null,

    /**
     * The all time run stats for the athlete.
     */
    @SerializedName("all_run_totals")
    var allRunTotals: ActivityTotal? = null,

    /**
     * The all time swim stats for the athlete.
     */
    @SerializedName("all_swim_totals")
    var allSwimTotals: ActivityTotal? = null

) : StravaResponse()
