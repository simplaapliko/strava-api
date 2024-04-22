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

package com.simplaapliko.strava.api

import com.simplaapliko.strava.api.StravaApiV3.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> Retrofit.createStravaApi(): T = create(T::class.java)

fun buildStravaApiRetrofit(
    client: OkHttpClient,
    applyToBuilder: (Retrofit.Builder.() -> Retrofit.Builder)? = null
): Retrofit {
    val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())

    if (applyToBuilder != null) {
        builder.applyToBuilder()
    }

    return builder.build()
}

fun buildStravaApiOkHttpClient(
    accessToken: () -> String,
    applyToBuilder: (OkHttpClient.Builder.() -> OkHttpClient.Builder)? = null,
): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(StravaAuthorizationInterceptor(accessToken))
        .addInterceptor(StravaResponseInterceptor())

    if (applyToBuilder != null) {
        builder.applyToBuilder()
    }

    return builder.build()
}
