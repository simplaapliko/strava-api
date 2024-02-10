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
import com.simplaapliko.strava.model.Gear
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.stravaapi.databinding.ActivityGearBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GearActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, GearActivity::class.java)
        }
    }

    private lateinit var binding: ActivityGearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getGear.setOnClickListener { getGear() }
    }

    private fun getGear() {
        setProgressVisibility(true)

        val athlete = dataRepository.getAuthenticatedAthlete()

        if (athlete == null) {
            binding.response.response.text =
                "athlete is null, make Athlete / GetAuthenticatedAthlete service call"
            setProgressVisibility(false)
            return
        }

        val gearId = when {
            athlete.shoes.isNullOrEmpty().not() -> athlete.shoes?.firstOrNull()?.id
            athlete.bikes.isNullOrEmpty().not() -> athlete.bikes?.firstOrNull()?.id
            else -> {
                binding.response.response.text = "athlete doesn't have shoes/bikes"
                setProgressVisibility(false)
                return
            }
        } ?: return

        val disposable = provideGearApi().getGear(gearId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onGetGearSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onGetGearSuccess(gear: StravaResponse<Gear>) {
        setProgressVisibility(false)

        dataRepository.setDetailedGear(gear.value)

        binding.response.response.text = gear.toString()
    }
}
