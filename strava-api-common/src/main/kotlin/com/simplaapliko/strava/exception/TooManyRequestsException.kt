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

package com.simplaapliko.strava.exception

import java.io.IOException

class TooManyRequestsException(
    val limit15Minute: Int?,
    val limitDaily: Int?,
    val readLimit15Minute: Int?,
    val readLimitDaily: Int?,
    val usage15Minute: Int?,
    val usageDaily: Int?,
    message: String,
) : IOException(message) {

    fun is15MinuteLimitReached(): Boolean {
        return usage15Minute != null && limit15Minute != null && usage15Minute >= limit15Minute
    }

    fun isDailyLimitReached(): Boolean {
        return usageDaily != null && limitDaily != null && usageDaily >= limitDaily
    }

    fun is15MinuteReadLimitReached(): Boolean {
        return usage15Minute != null && readLimit15Minute != null && usage15Minute >= readLimit15Minute
    }

    fun isDailyReadLimitReached(): Boolean {
        return usageDaily != null && readLimitDaily != null && usageDaily >= readLimitDaily
    }
}
