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

class AuthSharedPreferencesRepository(context: Context) : AuthRepository {

    companion object {
        const val DEFAULT_CODE = ""

        private const val PREFERENCES = "com.simplaapliko.stravaapi.auth"

        private const val PREF_CODE = "code"
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

    override fun getCode(): String {
        return sharedPreferences.getString(PREF_CODE, DEFAULT_CODE) ?: DEFAULT_CODE
    }

    override fun setCode(code: String) {
        sharedPreferences.edit()
            .putString(PREF_CODE, code)
            .apply()
    }
}
