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

package com.simplaapliko.strava.model

import com.google.common.truth.Truth
import com.simplaapliko.strava.gson.GsonUtils
import org.junit.Test

class TokenTest {

    @Test
    fun emptyJson_modelShouldHaveDefaultValues() {
        val json = "{}"

        val model = GsonUtils.gson()
            .fromJson(json, Token::class.java)

        Truth.assertThat(model.tokenType).isEmpty()
        Truth.assertThat(model.accessToken).isEmpty()
        Truth.assertThat(model.athleteSummary).isNull()
        Truth.assertThat(model.refreshToken).isEmpty()
        Truth.assertThat(model.expiresAt).isEqualTo(0)
        Truth.assertThat(model.state).isEmpty()
    }
}