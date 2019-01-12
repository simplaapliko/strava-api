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
import java.util.Date

data class Athlete(
    // region Summary Athlete
    /**
     * The unique identifier of the athlete
     */
    @SerializedName("id")
    var id: Int = 0,

    /**
     * Resource state, indicates level of detail.
     * Possible values: 1 -> "meta", 2 -> "summary", 3 -> "detail"
     */
    @SerializedName("resource_state")
    var resourceState: ResourceState = ResourceState.UNKNOWN,

    /**
     * The athlete's first name.
     */
    @SerializedName("firstname")
    var firstName: String = "",

    /**
     * The athlete's last name.
     */
    @SerializedName("lastname")
    var lastName: String = "",

    /**
     * URL to a 62x62 pixel profile picture.
     */
    @SerializedName("profile_medium")
    var profileMedium: String = "",

    /**
     * URL to a 124x124 pixel profile picture.
     */
    @SerializedName("profile")
    var profile: String = "",

    /**
     * The athlete's city.
     */
    @SerializedName("city")
    var city: String = "",

    /**
     * The athlete's state or geographical region.
     */
    @SerializedName("state")
    var state: String = "",

    /**
     * The athlete's country.
     */
    @SerializedName("country")
    var country: String = "",

    /**
     * The athlete's sex. May take one of the following values: M, F
     */
    @SerializedName("sex")
    var sex: Sex = Sex.UNKNOWN,

    /**
     * Whether the currently logged-in athlete follows this athlete.
     * May take one of the following values: pending, accepted, blocked
     */
    @SerializedName("friend")
    var friend: FriendState = FriendState.UNKNOWN,

    /**
     * Whether this athlete follows the currently logged-in athlete.
     * May take one of the following values: pending, accepted, blocked
     */
    @SerializedName("follower")
    var follower: FriendState = FriendState.UNKNOWN,

    /**
     * Deprecated. Use summit field instead. Whether the athlete has any Summit subscription.
     */
    @SerializedName("premium")
    var premium: Boolean = false,

    /**
     * Whether the athlete has any Summit subscription.
     */
    @SerializedName("summit")
    var summit: Boolean = false,

    /**
     * The time at which the athlete was created.
     */
    @SerializedName("created_at")
    var createdAt: Date? = null,

    /**
     * The time at which the athlete was last updated.
     */
    @SerializedName("updated_at")
    var updatedAt: Date? = null,
    // endregion Summary Athlete

    // region Detailed Athlete
    /**
     * The athlete's follower count.
     */
    @SerializedName("follower_count")
    var followerCount: Int = 0,

    /**
     * The athlete's friend count.
     */
    @SerializedName("friend_count")
    var friendCount: Int = 0,

    /**
     * The number or athletes mutually followed by this athlete and the currently logged-in athlete.
     */
    @SerializedName("mutual_friend_count")
    var mutualFriendCount: Int = 0,

    /**
     * The athlete's preferred unit system. May take one of the following values: feet, meters
     */
    @SerializedName("measurement_preference")
    var measurementPreference: MeasurementPreference = MeasurementPreference.UNKNOWN,

    /**
     * The athlete's FTP (Functional Threshold Power).
     */
    @SerializedName("ftp")
    var ftp: Int = 0,

    /**
     * The athlete's weight.
     */
    @SerializedName("weight")
    var weight: Double = 0.0,

    /**
     * The athlete's clubs.
     */
    @SerializedName("clubs")
    var clubs: List<SummaryClub> = emptyList(),

    /**
     * The athlete's bikes.
     */
    @SerializedName("bikes")
    var bikes: List<SummaryGear> = emptyList(),

    /**
     * The athlete's shoes.
     */
    @SerializedName("shoes")
    var shoes: List<SummaryGear> = emptyList()
    // endregion Detailed Athlete
) : StravaResponse()
