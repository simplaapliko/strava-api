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
import com.simplaapliko.stravaapi.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activity.setOnClickListener { goToActivityScreen() }
        binding.athlete.setOnClickListener { goToAthleteScreen() }
        binding.authorize.setOnClickListener { goToAuthorizeScreen() }
        binding.gear.setOnClickListener { goToGearScreen() }
        binding.token.setOnClickListener { goTokenScreen() }
    }

    private fun goToActivityScreen() {
        val intent = ActivityActivity.getStartIntent(this)
        startActivity(intent)
    }

    private fun goToAthleteScreen() {
        val intent = AthleteActivity.getStartIntent(this)
        startActivity(intent)
    }

    private fun goToAuthorizeScreen() {
        val intent = AuthorizeActivity.getStartIntent(this)
        startActivity(intent)
    }

    private fun goToGearScreen() {
        val intent = GearActivity.getStartIntent(this)
        startActivity(intent)
    }

    private fun goTokenScreen() {
        val intent = TokenActivity.getStartIntent(this)
        startActivity(intent)
    }
}
