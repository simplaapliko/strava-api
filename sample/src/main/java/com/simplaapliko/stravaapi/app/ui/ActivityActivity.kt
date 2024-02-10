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
import com.simplaapliko.strava.model.Activity
import com.simplaapliko.strava.model.ActivityZone
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Comment
import com.simplaapliko.strava.model.Lap
import com.simplaapliko.strava.model.Photo
import com.simplaapliko.strava.model.SportType
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.strava.model.UpdatableActivity
import com.simplaapliko.stravaapi.databinding.ActivityActivityBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ActivityActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ActivityActivity::class.java)
        }
    }

    private lateinit var binding: ActivityActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listAthleteActivities.setOnClickListener { listAthleteActivities() }
        binding.createActivity.setOnClickListener { createActivity() }
        binding.getActivity.setOnClickListener { getActivity() }
        binding.getActivityComments.setOnClickListener { getActivityComments() }
        binding.getActivityKudos.setOnClickListener { getActivityKudos() }
        binding.getActivityLaps.setOnClickListener { getActivityLaps() }
        binding.getActivityPhotos.setOnClickListener { getActivityPhotos() }
        binding.getActivityZones.setOnClickListener { getActivityZones() }
        binding.updateActivity.setOnClickListener { updateActivity() }
    }

    private fun listAthleteActivities() {
        setProgressVisibility(true)

        val disposable = provideActivityApi().getActivities(
            // after = 1546300800,
            // before = 1548979200,
            // page = 1,
            // perPage = 30
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onListAthleteActivitiesSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onListAthleteActivitiesSuccess(activities: StravaResponse<List<Activity>>) {
        setProgressVisibility(false)

        dataRepository.setActivities(activities.value)

        binding.response.response.text = activities.toString()
    }

    private fun createActivity() {
        setProgressVisibility(true)

        val disposable = provideActivityApi().createActivity(
            name = "Test activity name",
            sportType = SportType.RUN.name,
            startDateLocal = "2020-07-30T12:00:00",
            elapsedTime = 600,
            description = "Test activity description",
            distance = 2000.54f,
            trainer = 0,
            commute = 0
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onCreateActivitySuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onCreateActivitySuccess(activity: StravaResponse<Activity>) {
        setProgressVisibility(false)

        binding.response.response.text = activity.toString()
    }

    private fun getActivity() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivity(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivitySuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivitySuccess(activity: StravaResponse<Activity>) {
        setProgressVisibility(false)

        binding.response.response.text = activity.toString()
    }

    private fun getActivityComments() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivityComments(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivityCommentsSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivityCommentsSuccess(comments: StravaResponse<List<Comment>>) {
        setProgressVisibility(false)

        binding.response.response.text = comments.toString()
    }

    private fun getActivityKudos() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivityKudos(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivityKudosSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivityKudosSuccess(athlets: StravaResponse<List<Athlete>>) {
        setProgressVisibility(false)

        binding.response.response.text = athlets.toString()
    }

    private fun getActivityLaps() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivityLaps(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivityLapsSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivityLapsSuccess(laps: StravaResponse<List<Lap>>) {
        setProgressVisibility(false)

        binding.response.response.text = laps.toString()
    }

    private fun getActivityPhotos() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivityPhotos(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivityPhotosSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivityPhotosSuccess(photos: StravaResponse<List<Photo>>) {
        setProgressVisibility(false)

        binding.response.response.text = photos.toString()
    }

    private fun getActivityZones() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val disposable = provideActivityApi().getActivityZones(activity.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onGetActivityZonesSuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onGetActivityZonesSuccess(zones: StravaResponse<List<ActivityZone>>) {
        setProgressVisibility(false)

        binding.response.response.text = zones.toString()
    }

    private fun updateActivity() {
        setProgressVisibility(true)

        val activity = dataRepository.getActivities()?.firstOrNull()

        if (activity == null) {
            binding.response.response.text =
                "activity is null, make List Athlete Activity service call"
            setProgressVisibility(false)
            return
        }

        val update = UpdatableActivity(
            description = "test description"
        )

        val disposable = provideActivityApi().updateActivity(activity.id, update)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onUpdateActivitySuccess(it) }, { errorHandler(it) })
        disposables.add(disposable)
    }

    private fun onUpdateActivitySuccess(activity: StravaResponse<Activity>) {
        setProgressVisibility(false)

        binding.response.response.text = activity.toString()
    }
}
