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

import androidx.appcompat.app.AppCompatActivity
import com.simplaapliko.strava.api.TokenApi
import com.simplaapliko.strava.json.JsonUtils
import com.simplaapliko.stravaapi.app.data.AuthRepository
import com.simplaapliko.stravaapi.app.data.AuthSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.data.TokenRepository
import com.simplaapliko.stravaapi.app.data.TokenSharedPreferencesRepository
import com.simplaapliko.stravaapi.app.di.NetworkModule
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseActivity : AppCompatActivity() {

    protected val disposables = CompositeDisposable()

    val authRepository: AuthRepository
        get() = AuthSharedPreferencesRepository(applicationContext)

    val tokenRepository: TokenRepository
        get() = TokenSharedPreferencesRepository(applicationContext)


    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun provideTokenApi(): TokenApi {
        return provideTokenApi(NetworkModule().provideOkHttpClient())
    }

    fun provideTokenApi(client: OkHttpClient): TokenApi {
        val moshi = JsonUtils.moshi()

        return Retrofit.Builder()
                .client(client)
                .baseUrl(TokenApi.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(TokenApi::class.java)
    }
}
