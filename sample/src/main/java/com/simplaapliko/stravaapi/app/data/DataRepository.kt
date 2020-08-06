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

package com.simplaapliko.stravaapi.app.data

import com.simplaapliko.strava.model.Activity
import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Gear
import com.simplaapliko.strava.model.Zones

interface DataRepository {

    //region Activity
    fun getActivities(): List<Activity>?

    fun setActivities(activities: List<Activity>)
    //endregion Activity

    //region Athlete
    fun getAthleteStats(): ActivityStats?

    fun setAthleteStats(activityStats: ActivityStats)

    fun getAuthenticatedAthlete(): Athlete?

    fun setAuthenticatedAthlete(athlete: Athlete)

    fun getZones(): Zones?

    fun setZones(zones: Zones)
    //endregion Athlete

    //region Gear
    fun getDetailedGear(): Gear?

    fun setDetailedGear(gear: Gear)
    //endregion Gear
}
