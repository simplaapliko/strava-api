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
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Zones
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AthleteApi {

    /**
     * Returns the activity stats of an athlete.
     *
     * @param id The identifier of the athlete. Must match the authenticated athlete.
     */
    @GET("athletes/{id}/stats")
    fun getAthleteStats(
        @Path("id") id: Long
    ): Single<ActivityStats>

    /**
     * Returns the currently authenticated athlete.
     * Tokens with profile:read_all scope will receive a detailed athlete representation;
     * all others will receive a summary representation.
     */
    @GET("athlete")
    fun getAuthenticatedAthlete(): Single<Athlete>

    /**
     * Returns the the authenticated athlete’s heart rate and power zones.
     * Requires profile:read_all.
     */
    @GET("athlete/zones")
    fun getZones(): Single<Zones>

    /**
     * Update the currently authenticated athlete.
     * Requires profile:write scope.
     *
     * @param weight The weight of the athlete in kilograms.
     */
    @PUT("athlete")
    fun updateAthlete(
        @Query("weight") weight: Double
    ): Single<Athlete>
}
