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

package com.simplaapliko.strava.api

import com.simplaapliko.strava.model.ActivityStats
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AthleteApi {

    /**
     * Returns the activity stats of an athlete.
     * @param id The identifier of the athlete. Must match the authenticated athlete.
     * @param page Page number.
     * @param perPage Number of items per page. Defaults to 30.
     */
    @GET("athletes/{id}/stats")
    fun getAthleteStats(
        @Path("id") id: Int,
        @Query("page ") page : Int = 1,
        @Query("per_page ") perPage : Int = 30
    ): Single<ActivityStats>
}