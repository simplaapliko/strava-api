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

import com.squareup.moshi.Json

data class RefreshToken(

    @Json(name ="token_type")
    var tokenType: String = "",

    @Json(name ="access_token")
    var accessToken: String = "",

    @Json(name ="refresh_token")
    var refreshToken: String = "",

    @Json(name ="expires_at")
    var expiresAt: Int = 0
)
