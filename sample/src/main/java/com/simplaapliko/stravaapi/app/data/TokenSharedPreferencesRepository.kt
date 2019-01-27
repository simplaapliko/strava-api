/*
 * Copyright (C) 2019 Oleg Kan
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

class TokenSharedPreferencesRepository(context: Context) : TokenRepository {

    companion object {
        const val DEFAULT_EXPIRES_AT = 0
        const val DEFAULT_TOKEN = ""

        private const val PREFERENCES = "com.simplaapliko.stravaapi.token"

        private const val PREF_ACCESS_TOKEN = "access_token"
        private const val PREF_EXPIRES_AT = "expires_at"
        private const val PREF_REFRESH_TOKEN = "refresh_token"
    }

    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun clear() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }

    override fun getAccessToken(): String {
        return sharedPreferences.getString(PREF_ACCESS_TOKEN, DEFAULT_TOKEN) ?: DEFAULT_TOKEN
    }

    override fun setAccessToken(token: String) {
        sharedPreferences.edit()
            .putString(PREF_ACCESS_TOKEN, token)
            .apply()
    }

    override fun getRefreshToken(): String {
        return sharedPreferences.getString(PREF_REFRESH_TOKEN, DEFAULT_TOKEN) ?: DEFAULT_TOKEN
    }

    override fun setRefreshToken(token: String) {
        sharedPreferences.edit()
            .putString(PREF_REFRESH_TOKEN, token)
            .apply()
    }

    override fun getExpiresAt(): Int {
        return sharedPreferences.getInt(PREF_EXPIRES_AT, DEFAULT_EXPIRES_AT)
    }

    override fun setExpiresAt(value: Int) {
        sharedPreferences.edit()
                .putInt(PREF_EXPIRES_AT, value)
                .apply()
    }

    override fun isExpired(): Boolean {
        //TODO
        return true
    }
}
