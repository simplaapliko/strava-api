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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.simplaapliko.strava.model.Activity
import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Gear
import com.simplaapliko.strava.model.Zones

class DataSharedPreferencesRepository(context: Context) : DataRepository {

    companion object {
        private const val PREFERENCES = "com.simplaapliko.stravaapi.data"

        private const val PREF_ACTIVITIES = "activities"
        private const val PREF_ATHLETE_STATS = "athlete_stats"
        private const val PREF_AUTHENTICATED_ATHLETE = "authenticated_athlete"
        private const val PREF_DETAILED_GEAR = "detailed_gear"
        private const val PREF_ZONES = "zones"
    }

    private val sharedPreferences: SharedPreferences
    private val gson = Gson()

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun getActivities(): List<Activity>? {
        val json = sharedPreferences.getString(PREF_ACTIVITIES, null)

        val type = object : TypeToken<List<Activity>>() {}.type
        return if (json == null) null else gson.fromJson(json, type)
    }

    override fun setActivities(activities: List<Activity>) {
        val json = gson.toJson(activities)

        sharedPreferences.edit()
            .putString(PREF_ACTIVITIES, json)
            .apply()
    }

    override fun getAthleteStats(): ActivityStats? {
        val json = sharedPreferences.getString(PREF_ATHLETE_STATS, null)

        return if (json == null) null else gson.fromJson(json, ActivityStats::class.java)
    }

    override fun setAthleteStats(activityStats: ActivityStats) {
        val json = gson.toJson(activityStats)

        sharedPreferences.edit()
            .putString(PREF_ATHLETE_STATS, json)
            .apply()
    }

    override fun getAuthenticatedAthlete(): Athlete? {
        val json = sharedPreferences.getString(PREF_AUTHENTICATED_ATHLETE, null)

        return if (json == null) null else gson.fromJson(json, Athlete::class.java)
    }

    override fun setAuthenticatedAthlete(athlete: Athlete) {
        val json = gson.toJson(athlete)

        sharedPreferences.edit()
            .putString(PREF_AUTHENTICATED_ATHLETE, json)
            .apply()
    }

    override fun getZones(): Zones? {
        val json = sharedPreferences.getString(PREF_ZONES, null)

        return if (json == null) null else gson.fromJson(json, Zones::class.java)
    }

    override fun setZones(zones: Zones) {
        val json = gson.toJson(zones)

        sharedPreferences.edit()
            .putString(PREF_ZONES, json)
            .apply()
    }

    override fun getDetailedGear(): Gear? {
        val json = sharedPreferences.getString(PREF_DETAILED_GEAR, null)

        return if (json == null) null else gson.fromJson(json, Gear::class.java)
    }

    override fun setDetailedGear(gear: Gear) {
        val json = gson.toJson(gear)

        sharedPreferences.edit()
            .putString(PREF_DETAILED_GEAR, json)
            .apply()
    }
}
