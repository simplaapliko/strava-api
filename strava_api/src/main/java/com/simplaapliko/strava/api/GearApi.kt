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

import com.simplaapliko.strava.model.DetailedGear
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GearApi {

    /**
     * Returns an equipment using its identifier.
     * @param id The identifier of the gear.
     */
    @GET("gear/{id}")
    fun getGear(
        @Path("id") id: String
    ): Single<DetailedGear>
}
