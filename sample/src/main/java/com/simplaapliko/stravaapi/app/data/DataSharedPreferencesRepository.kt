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

import android.content.Context
import android.content.SharedPreferences
import com.simplaapliko.strava.json.JsonUtils
import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Zones
import com.squareup.moshi.JsonAdapter

class DataSharedPreferencesRepository(context: Context) : DataRepository {

    companion object {
        private const val PREFERENCES = "com.simplaapliko.stravaapi.data"

        private const val PREF_ATHLETE_STATS = "athlete_stats"
        private const val PREF_AUTHENTICATED_ATHLETE = "authenticated_athlete"
        private const val PREF_ZONES = "zones"
    }

    private val moshi = JsonUtils.moshi()
    private val athleteAdapter: JsonAdapter<Athlete> = moshi.adapter(Athlete::class.java)
    private val activityStatsAdapter: JsonAdapter<ActivityStats> = moshi.adapter(ActivityStats::class.java)
    private val zonesAdapter: JsonAdapter<Zones> = moshi.adapter(Zones::class.java)

    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun getAthleteStats(): ActivityStats? {
        val json = sharedPreferences.getString(PREF_ATHLETE_STATS, null)

        return if (json == null) null else activityStatsAdapter.fromJson(json)
    }

    override fun setAthleteStats(activityStats: ActivityStats) {
        val json = activityStatsAdapter.toJson(activityStats)

        sharedPreferences.edit()
                .putString(PREF_ATHLETE_STATS, json)
                .apply()
    }

    override fun getAuthenticatedAthlete(): Athlete? {
        val json = sharedPreferences.getString(PREF_AUTHENTICATED_ATHLETE, null)

        return if (json == null) null else athleteAdapter.fromJson(json)
    }

    override fun setAuthenticatedAthlete(athlete: Athlete) {
        val json = athleteAdapter.toJson(athlete)

        sharedPreferences.edit()
                .putString(PREF_AUTHENTICATED_ATHLETE, json)
                .apply()
    }

    override fun getZones(): Zones? {
        val json = sharedPreferences.getString(PREF_ZONES, null)

        return if (json == null) null else zonesAdapter.fromJson(json)
    }

    override fun setZones(zones: Zones) {
        val json = zonesAdapter.toJson(zones)

        sharedPreferences.edit()
                .putString(PREF_ZONES, json)
                .apply()
    }
}
