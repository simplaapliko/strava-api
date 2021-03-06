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

data class Gear(
    // region Summary Gear
    /**
     * The gear's unique identifier.
     */
    @SerializedName("id")
    var id: String,

    /**
     * Resource state, indicates level of detail.
     * Possible values: 2 -> "summary", 3 -> "detail"
     * @see com.simplaapliko.strava.model.ResourceState
     */
    @SerializedName("resource_state")
    var resourceState: Int,

    /**
     * Whether this gear's is the owner's default one.
     */
    @SerializedName("primary")
    var primary: Boolean,

    /**
     * The gear's name.
     */
    @SerializedName("name")
    var name: String,

    /**
     * The distance logged with this gear.
     */
    @SerializedName("distance")
    var distance: Double,
    // endregion Summary Gear

    // region Detailed Gear
    /**
     * The gear's brand name.
     */
    @SerializedName("brand_name")
    var brandName: String?,

    /**
     * The gear's model name.
     */
    @SerializedName("model_name")
    var modelName: String?,

    /**
     * The gear's frame type (bike only).
     * @see com.simplaapliko.strava.model.FrameType
     */
    @SerializedName("frame_type")
    var frameType: Int?,

    /**
     * The gear's description.
     */
    @SerializedName("description")
    var description: String?
    // endregion Detailed Gear
)
