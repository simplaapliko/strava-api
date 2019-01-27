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
import com.simplaapliko.strava.model.Token
import com.simplaapliko.stravaapi.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_get_token.*

class GetTokenActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, GetTokenActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_token)

        getToken()
    }

    private fun getToken() {
        val clientId = resources.getInteger(R.integer.client_id)
        val clientSecret = getString(R.string.client_secret)
        val code = authRepository.getCode()

        val disposable = provideTokenApi().token(clientId, clientSecret, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({t -> onTokedSuccess(t)}, {t -> errorHandler(t)})
        disposables.add(disposable)
    }

    private fun onTokedSuccess(token: Token) {
        tokenRepository.setAccessToken(token.accessToken)
        tokenRepository.setExpiresAt(token.expiresAt)
        tokenRepository.setRefreshToken(token.refreshToken)

        response.text = token.toString()
    }

    private fun errorHandler(throwable: Throwable) {
        response.text = throwable.message
    }
}
