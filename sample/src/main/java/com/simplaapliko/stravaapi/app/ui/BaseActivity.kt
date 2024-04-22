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

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.simplaapliko.strava.api.buildStravaApiRetrofit
import com.simplaapliko.strava.api.createStravaApi
import com.simplaapliko.strava.api.rxjava2.ActivityApi
import com.simplaapliko.strava.api.rxjava2.AthleteApi
import com.simplaapliko.strava.api.rxjava2.GearApi
import com.simplaapliko.strava.api.rxjava2.TokenApi
import com.simplaapliko.stravaapi.R
import com.simplaapliko.stravaapi.app.data.AuthRepository
import com.simplaapliko.stravaapi.app.data.AuthSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.data.DataRepository
import com.simplaapliko.stravaapi.app.data.DataSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.data.TokenRepository
import com.simplaapliko.stravaapi.app.data.TokenSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.di.NetworkModule
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

abstract class BaseActivity : AppCompatActivity() {

    protected val disposables = CompositeDisposable()

    val authRepository: AuthRepository
        get() = AuthSharedPreferencesRepository(applicationContext)

    val dataRepository: DataRepository
        get() = DataSharedPreferencesRepository(applicationContext)

    val tokenRepository: TokenRepository
        get() = TokenSharedPreferencesRepository(applicationContext)

    fun setProgressVisibility(isVisible: Boolean) {
        findViewById<View>(R.id.progress).visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun errorHandler(throwable: Throwable) {
        setProgressVisibility(false)

        findViewById<TextView>(R.id.response).text = throwable.message
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun provideActivityApi(): ActivityApi {
        return provideAuthorizedRetrofit().createStravaApi()
    }

    fun provideAthleteApi(): AthleteApi {
        return provideAuthorizedRetrofit().createStravaApi()
    }

    fun provideGearApi(): GearApi {
        return provideAuthorizedRetrofit().createStravaApi()
    }

    fun provideTokenApi(): TokenApi {
        return provideRetrofit().createStravaApi()
    }

    private fun provideAuthorizedRetrofit(): Retrofit {
        val token = tokenRepository.getAccessToken()
        return buildStravaApiRetrofit(NetworkModule().provideOkHttpClient(token)) {
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }
    }

    private fun provideRetrofit(): Retrofit {
        return buildStravaApiRetrofit(NetworkModule().provideOkHttpClient()) {
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }
    }
}
