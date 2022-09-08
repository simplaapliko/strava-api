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
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.simplaapliko.strava.api.Auth
import com.simplaapliko.stravaapi.R
import kotlinx.android.synthetic.main.activity_authorize.*

class AuthorizeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AuthorizeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorize)

        authorize.setOnClickListener { authorize() }
    }

    private fun authorize() {
        val clientId = resources.getInteger(R.integer.client_id)
        val redirectUri = getString(R.string.redirect_url)
        val scopes = getScopes()

        val url = Auth.UrlBuilder.build(
            clientId = clientId,
            redirectUri = redirectUri,
            scopes = scopes
        )

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)

        finish()
    }

    private fun getScopes(): List<Auth.Scope> {
        val list = mutableListOf<Auth.Scope>()

        if (read.isChecked) {
            list.add(Auth.Scope.READ)
        }
        if (read_all.isChecked) {
            list.add(Auth.Scope.READ_ALL)
        }
        if (profile_read_all.isChecked) {
            list.add(Auth.Scope.PROFILE_READ_ALL)
        }
        if (profile_write.isChecked) {
            list.add(Auth.Scope.PROFILE_WRITE)
        }
        if (activity_read.isChecked) {
            list.add(Auth.Scope.ACTIVITY_READ)
        }
        if (activity_read_all.isChecked) {
            list.add(Auth.Scope.ACTIVITY_READ_ALL)
        }
        if (activity_write.isChecked) {
            list.add(Auth.Scope.ACTIVITY_WRITE)
        }
        return list
    }
}
