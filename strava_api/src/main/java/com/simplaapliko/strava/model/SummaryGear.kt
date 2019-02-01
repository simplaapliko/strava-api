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

data class SummaryGear(
        /**
         * The gear's unique identifier.
         */
        @Json(name = "id")
        var id: String = "",

        /**
         * Resource state, indicates level of detail.
         * Possible values: 2 -> "summary", 3 -> "detail"
         */
        @Json(name = "resource_state")
        var resourceState: ResourceState = ResourceState.UNKNOWN,

        /**
         * Whether this gear's is the owner's default one.
         */
        @Json(name = "primary")
        var primary: Boolean = false,

        /**
         * The gear's name.
         */
        @Json(name = "name")
        var name: String = "",

        /**
         * The distance logged with this gear.
         */
        @Json(name = "distance")
        var distance: Double = 0.0
)
