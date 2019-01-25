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

import android.os.Bundle
import com.simplaapliko.strava.api.Auth
import com.simplaapliko.stravaapi.R

class AuthorizationCallbackActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorized)

        val code = intent?.data?.getQueryParameter(Auth.Response.CODE)
        val scope = intent?.data?.getQueryParameter(Auth.Response.SCOPE)
        val state = intent?.data?.getQueryParameter(Auth.Response.STATE)
    }
}
