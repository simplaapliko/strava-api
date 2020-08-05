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

data class Comment(

    /**
     * The unique identifier of this comment
     */
    @SerializedName("id")
    val id: Long,

    /**
     * The identifier of the activity this comment is related to
     */
    @SerializedName("activity_id")
    val activityId: Long,

    /**
     * The content of the comment
     */
    @SerializedName("text")
    val text: String,

    /**
     * An instance of SummaryAthlete.
     */
    @SerializedName("athlete")
    val athlete: Athlete,

    /**
     * The time at which this comment was created.
     */
    @SerializedName("created_at")
    val createdAt: String
)
