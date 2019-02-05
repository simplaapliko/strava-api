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
import com.simplaapliko.strava.model.DetailedGear
import com.simplaapliko.stravaapi.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_gear.*
import kotlinx.android.synthetic.main.include_response.*

class GearActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, GearActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gear)

        get_gear.setOnClickListener { getGear() }
    }

    private fun getGear() {
        setProgressVisibility(true)

        val athlete = dataRepository.getAuthenticatedAthlete()

        if (athlete == null) {
            response.text = "athlete is null, make Athlete / GetAuthenticatedAthlete service call"
            setProgressVisibility(false)
            return
        }

        val gearId: String

        when {
            athlete.shoes.isNotEmpty() -> gearId = athlete.shoes[0].id
            athlete.bikes.isNotEmpty() -> gearId = athlete.bikes[0].id
            else -> {
                response.text = "athlete doesn't have shoes/bikes"
                setProgressVisibility(false)
                return
            }
        }

        val disposable = provideGearApi().getGear(gearId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t -> onGetGearSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onGetGearSuccess(detailedGear: DetailedGear) {
        setProgressVisibility(false)

        dataRepository.setDetailedGear(detailedGear)

        response.text = detailedGear.toString()
    }
}
