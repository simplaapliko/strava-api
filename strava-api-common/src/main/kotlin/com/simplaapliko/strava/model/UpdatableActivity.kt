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

data class UpdatableActivity(

    /**
     * Whether this activity is a commute
     */
    @SerializedName("commute")
    val commute: Boolean? = null,

    /**
     * Whether this activity was recorded on a training machine
     */
    @SerializedName("trainer")
    val trainer: Boolean? = null,

    /**
     * The description of the activity
     */
    @SerializedName("description")
    val description: String? = null,

    /**
     * The name of the activity
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * An instance of ActivityType.
     * @see com.simplaapliko.strava.model.ActivityType
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Identifier for the gear associated with the activity. ‘none’ clears gear from activity
     */
    @SerializedName("gear_id")
    val gearId: String? = null
)
