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

data class Activity(

    /**
     * Resource state, indicates level of detail.
     * Possible values: 1 -> "meta", 2 -> "summary", 3 -> "detail"
     * @see com.simplaapliko.strava.model.ResourceState
     */
    @SerializedName("resource_state")
    var resourceState: Int,

    // region Summary
    /**
     * The unique identifier of the activity
     */
    @SerializedName("id")
    val id: Long,

    /**
     * The identifier provided at upload time
     */
    @SerializedName("external_id")
    val externalId: String?,

    /**
     * The identifier of the upload that resulted in this activity
     */
    @SerializedName("upload_id")
    val uploadId: Long?,

    /**
     * An instance of MetaAthlete.
     */
    @SerializedName("athlete")
    val athlete: MetaAthlete,

    /**
     * The name of the activity
     */
    @SerializedName("name")
    val name: String,

    /**
     * The activity's distance, in meters
     */
    @SerializedName("distance")
    val distance: Double,

    /**
     * The activity's moving time, in seconds
     */
    @SerializedName("moving_time")
    val movingTime: Int,

    /**
     * The activity's elapsed time, in seconds
     */
    @SerializedName("elapsed_time")
    val elapsedTime: Int,

    /**
     * The activity's total elevation gain.
     */
    @SerializedName("total_elevation_gain")
    val totalElevationGain: Double?,

    /**
     * The activity's highest elevation, in meters
     */
    @SerializedName("elev_high")
    val elevationHigh: Double?,

    /**
     * The activity's lowest elevation, in meters
     */
    @SerializedName("elev_low")
    val elevationLow: Double?,

    /**
     * An instance of ActivityType.
     * @see com.simplaapliko.strava.model.ActivityType
     */
    @SerializedName("type")
    val type: String,

    /**
     * The time at which the activity was started.
     */
    @SerializedName("start_date")
    val startDate: String,

    /**
     * The time at which the activity was started in the local timezone.
     */
    @SerializedName("start_date_local")
    val startDateLocal: String,

    /**
     * The timezone of the activity
     */
    @SerializedName("timezone")
    val timezone: String,

    /**
     * An instance of LatLng.
     */
    @SerializedName("start_latlng")
    val startLatLng: List<Double>?,

    /**
     * An instance of LatLng.
     */
    @SerializedName("end_latlng")
    val endLatLng: List<Double>?,

    /**
     * The number of achievements gained during this activity
     */
    @SerializedName("achievement_count")
    val achievementCount: Int,

    /**
     * The number of PRs gained during this activity
     */
    @SerializedName("pr_count")
    val prCount: Int,

    /**
     * The number of kudos given for this activity
     */
    @SerializedName("kudos_count")
    val kudosCount: Int,

    /**
     * The number of comments for this activity
     */
    @SerializedName("comment_count")
    val commentCount: Int,

    /**
     * The number of athletes for taking part in a group activity
     */
    @SerializedName("athlete_count")
    val athleteCount: Int,

    /**
     * The number of Instagram photos for this activity
     */
    @SerializedName("photo_count")
    val photoCount: Int,

    /**
     * The number of Instagram and Strava photos for this activity
     */
    @SerializedName("total_photo_count")
    val totalPhotoCount: Int,

    /**
     * An instance of PolylineMap.
     */
    @SerializedName("map")
    val map: PolylineMap,

    /**
     * Whether this activity was recorded on a training machine
     */
    @SerializedName("trainer")
    val trainer: Boolean,

    /**
     * Whether this activity is a commute
     */
    @SerializedName("commute")
    val commute: Boolean,

    /**
     * Whether this activity was created manually
     */
    @SerializedName("manual")
    val manual: Boolean,

    /**
     * Whether this activity is private
     */
    @SerializedName("private")
    val private: Boolean,

    /**
     * Whether this activity is flagged
     */
    @SerializedName("flagged")
    val flagged: Boolean,

    /**
     * The activity's workout type
     */
    @SerializedName("workout_type")
    val workoutType: Int?,

    /**
     * The unique identifier of the upload in string format
     */
    @SerializedName("upload_id_str")
    val uploadIdString: String?,

    /**
     * The activity's average speed, in meters per second
     */
    @SerializedName("average_speed")
    val averageSpeed: Double?,

    /**
     * The activity's max speed, in meters per second
     */
    @SerializedName("max_speed")
    val maxSpeed: Double?,

    /**
     * Whether the logged-in athlete has kudoed this activity
     */
    @SerializedName("has_kudoed")
    val hasKudoed: Boolean,

    /**
     * The id of the gear for the activity
     */
    @SerializedName("gear_id")
    val gearId: String?,

    /**
     * The total work done in kilojoules during this activity. Rides only
     */
    @SerializedName("kilojoules")
    val kilojoules: Double?,

    /**
     * Average power output in watts during this activity. Rides only
     */
    @SerializedName("average_watts")
    val averageWatts: Double?,

    /**
     * Whether the watts are from a power meter, false if estimated
     */
    @SerializedName("device_watts")
    val deviceWatts: Boolean?,

    /**
     * Rides with power meter data only
     */
    @SerializedName("max_watts")
    val maxWatts: Int?,

    @SerializedName("location_city")
    val locationCity: String?,

    @SerializedName("location_state")
    val locationState: String?,

    @SerializedName("location_country")
    val locationCountry: String?,

    @SerializedName("suffer_score")
    val sufferScore: Int?,

    @SerializedName("average_temp")
    val averageTemp: Int?,
    // endregion Summary

    // region Detailed
    /**
     * Similar to Normalized Power. Rides with power meter data only
     */
    @SerializedName("weighted_average_watts")
    val weightedAverageWatts: Int?,

    /**
     * The description of the activity
     */
    @SerializedName("description")
    val description: String?,

    @SerializedName("photos")
    val photos: PhotosSummary?,

    @SerializedName("gear")
    val gear: Gear?,

    /**
     * The number of kilocalories consumed during this activity
     */
    @SerializedName("calories")
    val calories: Double?,

    @SerializedName("segment_efforts")
    val segmentEfforts: List<DetailedSegmentEffort>?,

    /**
     * The name of the device used to record the activity
     */
    @SerializedName("device_name")
    val deviceName: String?,

    /**
     * The token used to embed a Strava activity
     */
    @SerializedName("embed_token")
    val embedToken: String?,

    /**
     * The splits of this activity in metric units (for runs)
     */
    @SerializedName("splits_metric")
    val splitsMetric: List<Split>?,

    /**
     * The splits of this activity in imperial units (for runs)
     */
    @SerializedName("splits_standard")
    val splitsStandard: List<Split>?,

    @SerializedName("laps")
    val laps: List<Lap>?,

    @SerializedName("best_efforts")
    val bestEfforts: List<DetailedSegmentEffort>?
    // endregion Detailed
)
