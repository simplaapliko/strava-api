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

package com.simplaapliko.strava.api

import com.simplaapliko.strava.exception.NotFoundException
import com.simplaapliko.strava.exception.PaymentRequiredException
import com.simplaapliko.strava.exception.StravaException
import com.simplaapliko.strava.exception.TooManyRequestsException
import com.simplaapliko.strava.exception.UnauthorizedException
import com.simplaapliko.strava.exception.UnknownStravaException
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray
import org.json.JSONObject

internal class StravaAuthorizationInterceptor(private val bearer: () -> String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
            .header("Authorization", "Bearer ${bearer()}")
            .build()
        return chain.proceed(request)
    }
}

internal class StravaResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        val limits = getLimits(response.headers)

        val responseBody = response.body ?: throw StravaException("null body")
        val responseString = responseBody.string()

        when (response.code) {
            200, 201 -> {
                val jsonObject = JSONObject()
                jsonObject.put("limit15Minute", limits.limit15Minute)
                jsonObject.put("limitDaily", limits.limitDaily)
                jsonObject.put("usage15Minute", limits.usage15Minute)
                jsonObject.put("usageDaily", limits.usageDaily)

                if (responseString.startsWith("[")) {
                    jsonObject.put("value", JSONArray(responseString))
                } else {
                    jsonObject.put("value", JSONObject(responseString))
                }

                val contentType: MediaType? = responseBody.contentType()
                val body: ResponseBody = jsonObject.toString().toResponseBody(contentType)
                return response.newBuilder().body(body).build()
            }
            401 -> throw UnauthorizedException(responseString)
            402 -> throw PaymentRequiredException(responseString)
            404 -> throw NotFoundException(responseString)
            429 -> {
                throw TooManyRequestsException(
                    limit15Minute = limits.limit15Minute,
                    limitDaily = limits.limitDaily,
                    usage15Minute = limits.usage15Minute,
                    usageDaily = limits.usageDaily,
                    message = responseString
                )
            }
            500 -> throw StravaException(responseString)
            else -> throw UnknownStravaException(responseString)
        }
    }
}

private const val LIMIT_HEADER = "X-RateLimit-Limit"
private const val USAGE_HEADER = "X-RateLimit-Usage"

private fun getLimits(headers: Headers): Limits {
    val limits = headers[LIMIT_HEADER]
    val usages = headers[USAGE_HEADER]

    return if (limits != null && usages != null) {
        val limitsArray = limits.split(",").map { it.toInt() }
        val usagesArray = usages.split(",").map { it.toInt() }

        Limits(
            limit15Minute = limitsArray.first(),
            limitDaily = limitsArray.last(),
            usage15Minute = usagesArray.first(),
            usageDaily = usagesArray.last()
        )
    } else {
        Limits()
    }
}

private data class Limits(
    val limit15Minute: Int? = null,
    val limitDaily: Int? = null,
    val usage15Minute: Int? = null,
    val usageDaily: Int? = null,
)
