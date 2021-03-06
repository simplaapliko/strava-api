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
import androidx.appcompat.app.AppCompatActivity
import com.simplaapliko.strava.api.ActivityApi
import com.simplaapliko.strava.api.AthleteApi
import com.simplaapliko.strava.api.GearApi
import com.simplaapliko.strava.api.StravaApiV3
import com.simplaapliko.strava.api.TokenApi
import com.simplaapliko.stravaapi.app.data.AuthRepository
import com.simplaapliko.stravaapi.app.data.AuthSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.data.DataRepository
import com.simplaapliko.stravaapi.app.data.DataSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.data.TokenRepository
import com.simplaapliko.stravaapi.app.data.TokenSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.di.NetworkModule
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.include_response.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseActivity : AppCompatActivity() {

    protected val disposables = CompositeDisposable()

    val authRepository: AuthRepository
        get() = AuthSharedPreferencesRepository(applicationContext)

    val dataRepository: DataRepository
        get() = DataSharedPreferencesRepository(applicationContext)

    val tokenRepository: TokenRepository
        get() = TokenSharedPreferencesRepository(applicationContext)

    fun setProgressVisibility(isVisible: Boolean) {
        progress.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun errorHandler(throwable: Throwable) {
        setProgressVisibility(false)

        response.text = throwable.message
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun provideActivityApi(): ActivityApi {
        return provideApi(provideAuthorizedOkHttpClient(), StravaApiV3.BASE_URL)
    }

    fun provideAthleteApi(): AthleteApi {
        return provideApi(provideAuthorizedOkHttpClient(), StravaApiV3.BASE_URL)
    }

    fun provideGearApi(): GearApi {
        return provideApi(provideAuthorizedOkHttpClient(), StravaApiV3.BASE_URL)
    }

    fun provideTokenApi(): TokenApi {
        return provideApi(NetworkModule().provideOkHttpClient(), StravaApiV3.BASE_URL)
    }

    private fun provideAuthorizedOkHttpClient(): OkHttpClient {
        val token = tokenRepository.getAccessToken()
        return NetworkModule().provideOkHttpClient(token)
    }

    private inline fun <reified T> provideApi(client: OkHttpClient, baseUrl: String): T {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
    }
}
