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

data class Athlete(
    // region Summary Athlete
    /**
     * The unique identifier of the athlete
     */
    @SerializedName("id")
    var id: Long,

    /**
     * The unique identifier of the athlete
     */
    @SerializedName("username")
    var username: String,

    /**
     * Resource state, indicates level of detail.
     * Possible values: 1 -> "meta", 2 -> "summary", 3 -> "detail"
     * @see com.simplaapliko.strava.model.ResourceState
     */
    @SerializedName("resource_state")
    var resourceState: Int,

    /**
     * The athlete's first name.
     */
    @SerializedName("firstname")
    var firstName: String,

    /**
     * The athlete's last name.
     */
    @SerializedName("lastname")
    var lastName: String,

    /**
     * URL to a 62x62 pixel profile picture.
     */
    @SerializedName("profile_medium")
    var profileMedium: String,

    /**
     * URL to a 124x124 pixel profile picture.
     */
    @SerializedName("profile")
    var profile: String,

    /**
     * The athlete's city.
     */
    @SerializedName("city")
    var city: String?,

    /**
     * The athlete's state or geographical region.
     */
    @SerializedName("state")
    var state: String?,

    /**
     * The athlete's country.
     */
    @SerializedName("country")
    var country: String?,

    /**
     * The athlete's sex. May take one of the following values: M, F
     */
    @SerializedName("sex")
    var sex: String?,

    /**
     * Whether the currently logged-in athlete follows this athlete.
     * May take one of the following values: pending, accepted, blocked
     */
    @SerializedName("friend")
    var friend: String?,

    /**
     * Whether this athlete follows the currently logged-in athlete.
     * May take one of the following values: pending, accepted, blocked
     */
    @SerializedName("follower")
    var follower: String?,

    /**
     * Deprecated. Use summit field instead. Whether the athlete has any Summit subscription.
     */
    @SerializedName("premium")
    var premium: Boolean,

    /**
     * Whether the athlete has any Summit subscription.
     */
    @SerializedName("summit")
    var summit: Boolean,

    /**
     * The time at which the athlete was created.
     */
    @SerializedName("created_at")
    var createdAt: String?,

    /**
     * The time at which the athlete was last updated.
     */
    @SerializedName("updated_at")
    var updatedAt: String? ,

    @SerializedName("badge_type_id")
    var badgeTypeId: Int,
    // endregion Summary Athlete

    // region Detailed Athlete
    /**
     * The athlete's follower count.
     */
    @SerializedName("follower_count")
    var followerCount: Int,

    /**
     * The athlete's friend count.
     */
    @SerializedName("friend_count")
    var friendCount: Int,

    /**
     * The number or athletes mutually followed by this athlete and the currently logged-in athlete.
     */
    @SerializedName("mutual_friend_count")
    var mutualFriendCount: Int,

    /**
     * The athlete's preferred unit system. May take one of the following values: feet, meters
     * @see com.simplaapliko.strava.model.MeasurementPreference
     */
    @SerializedName("measurement_preference")
    var measurementPreference: String?,

    /**
     * The athlete's FTP (Functional Threshold Power).
     */
    @SerializedName("ftp")
    var ftp: Int?,

    /**
     * The athlete's weight.
     */
    @SerializedName("weight")
    var weight: Double,

    /**
     * The athlete's clubs.
     */
    @SerializedName("clubs")
    var clubs: List<SummaryClub>?,

    /**
     * The athlete's bikes.
     */
    @SerializedName("bikes")
    var bikes: List<Gear>?,

    /**
     * The athlete's shoes.
     */
    @SerializedName("shoes")
    var shoes: List<Gear>?
    // endregion Detailed Athlete
) : StravaResponse()
