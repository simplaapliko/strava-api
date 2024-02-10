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
import com.simplaapliko.strava.model.RefreshToken
import com.simplaapliko.strava.model.Token
import com.simplaapliko.stravaapi.R
import com.simplaapliko.stravaapi.databinding.ActivityTokenBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TokenActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, TokenActivity::class.java)
        }
    }

    private lateinit var binding: ActivityTokenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getToken.setOnClickListener { getToken() }
        binding.refreshToken.setOnClickListener { refreshToken() }
        binding.deauthorize.setOnClickListener { deauthorize() }
    }

    private fun getToken() {
        setProgressVisibility(true)

        val clientId = resources.getInteger(R.integer.client_id)
        val clientSecret = getString(R.string.client_secret)
        val code = authRepository.getCode()

        val disposable = provideTokenApi().token(clientId, clientSecret, code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onGetTokedSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onGetTokedSuccess(token: Token) {
        setProgressVisibility(false)

        token.athleteSummary?.let { tokenRepository.setAthlete(it) }
        tokenRepository.setAccessToken(token.accessToken)
        tokenRepository.setExpiresAt(token.expiresAt)
        tokenRepository.setRefreshToken(token.refreshToken)

        binding.response.response.text = token.toString()
    }

    private fun refreshToken() {
        setProgressVisibility(true)

        val clientId = resources.getInteger(R.integer.client_id)
        val clientSecret = getString(R.string.client_secret)
        val refreshToken = tokenRepository.getRefreshToken()

        val disposable = provideTokenApi().refreshToken(clientId, clientSecret, refreshToken)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t -> onRefreshTokedSuccess(t) }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onRefreshTokedSuccess(refreshToken: RefreshToken) {
        setProgressVisibility(false)

        tokenRepository.setAccessToken(refreshToken.accessToken)
        tokenRepository.setExpiresAt(refreshToken.expiresAt)
        tokenRepository.setRefreshToken(refreshToken.refreshToken)

        binding.response.response.text = refreshToken.toString()
    }

    private fun deauthorize() {
        setProgressVisibility(true)

        val accessToken = tokenRepository.getAccessToken()

        val disposable = provideTokenApi().deauthorize(accessToken)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ onDeauthorizeSuccess() }, { t -> errorHandler(t) })
        disposables.add(disposable)
    }

    private fun onDeauthorizeSuccess() {
        setProgressVisibility(false)

        authRepository.clear()
        tokenRepository.clear()

        binding.response.response.text = "Deauthorized"
    }
}
