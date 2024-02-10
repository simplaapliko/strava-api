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

package com.simplaapliko.stravaapi.app.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.strava.model.Zones
import com.simplaapliko.stravaapi.databinding.ActivityAthleteBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AthleteActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AthleteActivity::class.java)
        }
    }

    private lateinit var binding: ActivityAthleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAthleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getAuthenticatedAthlete.setOnClickListener { getAuthenticatedAthlete() }
        binding.getAthleteStats.setOnClickListener { getAthleteStats() }
        binding.getZones.setOnClickListener { getZones() }
        binding.updateAthlete.setOnClickListener { updateAthlete() }
    }

    private fun getAuthenticatedAthlete() {
        setProgressVisibility(true)

        val disposable = provideAthleteApi().getAuthenticatedAthlete()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onAuthenticatedAthleteSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onAuthenticatedAthleteSuccess(athlete: StravaResponse<Athlete>) {
        setProgressVisibility(false)

        dataRepository.setAuthenticatedAthlete(athlete.value)

        binding.response.response.text = athlete.toString()
    }

    private fun getAthleteStats() {
        setProgressVisibility(true)

        val athlete = tokenRepository.getAthlete()

        if (athlete == null) {
            binding.response.response.text = "athlete is null, make a GetToken service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideAthleteApi().getAthleteStats(athlete.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onGetAthleteStatsSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onGetAthleteStatsSuccess(activityStats: StravaResponse<ActivityStats>) {
        setProgressVisibility(false)

        dataRepository.setAthleteStats(activityStats.value)

        binding.response.response.text = activityStats.toString()
    }

    private fun getZones() {
        setProgressVisibility(true)

        val disposable = provideAthleteApi().getZones()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onGetZonesSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onGetZonesSuccess(zones: StravaResponse<Zones>) {
        setProgressVisibility(false)

        dataRepository.setZones(zones.value)

        binding.response.response.text = zones.toString()
    }

    private fun updateAthlete() {
        setProgressVisibility(true)

        val disposable = provideAthleteApi().updateAthlete(71.0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onUpdateAthleteSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onUpdateAthleteSuccess(athlete: StravaResponse<Athlete>) {
        setProgressVisibility(false)

        binding.response.response.text = athlete.toString()
    }
}
