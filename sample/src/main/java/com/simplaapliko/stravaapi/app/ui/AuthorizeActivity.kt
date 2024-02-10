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
import com.simplaapliko.stravaapi.databinding.ActivityAuthorizeBinding

class AuthorizeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AuthorizeActivity::class.java)
        }
    }

    private lateinit var binding: ActivityAuthorizeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.authorize.setOnClickListener { authorize() }
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

        if (binding.read.isChecked) {
            list.add(Auth.Scope.READ)
        }
        if (binding.readAll.isChecked) {
            list.add(Auth.Scope.READ_ALL)
        }
        if (binding.profileReadAll.isChecked) {
            list.add(Auth.Scope.PROFILE_READ_ALL)
        }
        if (binding.profileWrite.isChecked) {
            list.add(Auth.Scope.PROFILE_WRITE)
        }
        if (binding.activityRead.isChecked) {
            list.add(Auth.Scope.ACTIVITY_READ)
        }
        if (binding.activityReadAll.isChecked) {
            list.add(Auth.Scope.ACTIVITY_READ_ALL)
        }
        if (binding.activityWrite.isChecked) {
            list.add(Auth.Scope.ACTIVITY_WRITE)
        }
        return list
    }
}
