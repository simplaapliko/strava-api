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

import com.squareup.moshi.Json

data class SummaryClub(
        /**
         * The club's unique identifier.
         */
        @Json(name = "id")
        var id: Int = 0,

        /**
         * Resource state, indicates level of detail.
         * Possible values: 1 -> "meta", 2 -> "summary", 3 -> "detail"
         */
        @Json(name = "resource_state")
        var resourceState: ResourceState = ResourceState.UNKNOWN,

        /**
         * The club's name.
         */
        @Json(name = "name")
        var name: String = "",

        /**
         * URL to a 60x60 pixel profile picture.
         */
        @Json(name = "profile_medium")
        var profileMedium: String = "",

        /**
         * URL to a ~1185x580 pixel cover photo.
         */
        @Json(name = "cover_photo")
        var coverPhoto: String = "",

        /**
         * URL to a ~360x176 pixel cover photo.
         */
        @Json(name = "cover_photo_small")
        var coverPhotoSmall: String = "",

        /**
         * May take one of the following values: cycling, running, triathlon, other
         */
        @Json(name = "sport_type")
        var sportType: SportType = SportType.UNKNOWN,

        /**
         * The club's city.
         */
        @Json(name = "city")
        var city: String = "",

        /**
         * The club's state or geographical region.
         */
        @Json(name = "state")
        var state: String = "",

        /**
         * The club's country.
         */
        @Json(name = "country")
        var country: String = "",

        /**
         * Whether the club is private.
         */
        @Json(name = "private")
        var private: Boolean = false,

        /**
         * The club's member count.
         */
        @Json(name = "member_count")
        var memberCount: Int = 0,

        /**
         * Whether the club is featured or not.
         */
        @Json(name = "featured")
        var featured: Boolean = false,

        /**
         * Whether the club is verified or not.
         */
        @Json(name = "verified")
        var verified: Boolean = false,

        /**
         * The club's vanity URL.
         */
        @Json(name = "url")
        var url: String = ""
)
