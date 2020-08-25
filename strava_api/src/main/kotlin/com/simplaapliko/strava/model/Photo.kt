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

data class Photo(

    // region Meta Photo
    @SerializedName("id")
    val id: Long?,

    @SerializedName("source")
    val source: Int,

    @SerializedName("unique_id")
    val uniqueId: String,

    @SerializedName("urls")
    val urls: Map<String, String>,
    // endregion Meta Photo

    // region Summary Photo
    @SerializedName("athlete_id")
    val athleteId: Long?,

    @SerializedName("activity_id")
    val activityId: Long?,

    @SerializedName("activity_name")
    val activityName: String?,

    @SerializedName("caption")
    val caption: String?,

    @SerializedName("uploaded_at")
    val uploadedAt: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("created_at_local")
    val createdAtLocal: String?,

    @SerializedName("sizes")
    val sizes: Map<String, List<Int>>?,

    @SerializedName("default_photo")
    val defaultPhoto: Boolean?,
    // endregion Summary Photo
)
