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

data class SummarySegment(

    /**
     * The unique identifier of this segment
     */
    @SerializedName("id")
    val id: Long,

    /**
     * The name of this segment
     */
    @SerializedName("name")
    val name: String,

    /**
     * May take one of the following values: Ride, Run
     * @see com.simplaapliko.strava.model.ActivityType
     */
    @SerializedName("activity_type")
    val activityType: String,

    /**
     * The segment's distance, in meters
     */
    @SerializedName("distance")
    val distance: Double,

    /**
     * The segment's average grade, in percents
     */
    @SerializedName("average_grade")
    val averageGrade: Double,

    /**
     * The segments's maximum grade, in percents
     */
    @SerializedName("maximum_grade")
    val maximumGrade: Double,

    /**
     * The segments's highest elevation, in meters
     */
    @SerializedName("elevation_high")
    val elevationHigh: Double,

    /**
     * The segments's lowest elevation, in meters
     */
    @SerializedName("elevation_low")
    val elevationLow: Double,

    /**
     * An instance of LatLng.
     */
    @SerializedName("start_latlng")
    val startLatLng: List<Double>,

    /**
     * An instance of LatLng.
     */
    @SerializedName("end_latlng")
    val endLatLng: List<Float>,

    /**
     * The category of the climb [0, 5]. Higher is harder ie. 5 is Hors catégorie, 0 is uncategorized in climb_category.
     */
    @SerializedName("climb_category")
    val climbCategory: Int,

    /**
     * The segments's city.
     */
    @SerializedName("city")
    val city: String,

    /**
     * The segments's state or geographical region.
     */
    @SerializedName("state")
    val state: String,

    /**
     * The segment's country.
     */
    @SerializedName("country")
    val country: String,

    /**
     * Whether this segment is private.
     */
    @SerializedName("private")
    val private: Boolean,

    /**
     * An instance of SummarySegmentEffort.
     */
    @SerializedName("athlete_pr_effort")
    val athletePrEffort: SummarySegmentEffort,


    /**
     * An instance of SummaryPRSegmentEffort.
     */
    @SerializedName("athlete_segment_stats")
    val athleteSegmentStats: SummaryPRSegmentEffort
)
