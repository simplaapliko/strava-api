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

package com.simplaapliko.strava.source.generator

import com.simplaapliko.strava.source.generateFiles
import com.simplaapliko.strava.source.utils.fieldParam
import com.simplaapliko.strava.source.utils.int
import com.simplaapliko.strava.source.utils.refreshToken
import com.simplaapliko.strava.source.utils.string
import com.simplaapliko.strava.source.utils.token
import com.simplaapliko.strava.source.utils.unit
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private const val INTERFACE_NAME = "TokenApi"

fun generateTokenApiFiles() {
    val mapOfFunctions = mapOf(
        { tokenFunction() } to token,
        { refreshTokenFunction() } to refreshToken,
        { deauthorizeFunction() } to unit,
    )

    generateFiles(INTERFACE_NAME, mapOfFunctions)
}

private fun tokenFunction() = FunSpec.builder("token")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        @param clientId The application’s ID, obtained during registration.
        @param clientSecret The application’s secret, obtained during registration.
        @param code The 'code' parameter obtained in the redirect.
        @param grantType The grant type for the request.
             For initial authentication, must always be "authorization_code".
        """.trimIndent()
    )
    .addAnnotation(FormUrlEncoded::class)
    .addAnnotation(
        AnnotationSpec.builder(POST::class)
            .addMember("%S", "oauth/token")
            .build()
    )
    .addParameter(fieldParam("clientId", "client_id", int))
    .addParameter(fieldParam("clientSecret", "client_secret", string))
    .addParameter(fieldParam("code", "code", string))
    .addParameter(fieldParam("grantType", "grant_type", string, "authorization_code"))

private fun refreshTokenFunction() = FunSpec.builder("refreshToken")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        @param clientId The application’s ID, obtained during registration.
        @param clientSecret The application’s secret, obtained during registration.
        @param refreshToken The refresh token obtained for this user,
             to be used to get the next access token for this user.
        @param grantType The grant type for the request.
             When refreshing an access token, must always be "refresh_token".
        """.trimIndent()
    )
    .addAnnotation(FormUrlEncoded::class)
    .addAnnotation(
        AnnotationSpec.builder(POST::class)
            .addMember("%S", "oauth/token")
            .build()
    )
    .addParameter(fieldParam("clientId", "client_id", int))
    .addParameter(fieldParam("clientSecret", "client_secret", string))
    .addParameter(fieldParam("refreshToken", "refresh_token", string))
    .addParameter(fieldParam("grantType", "grant_type", string, "refresh_token"))

private fun deauthorizeFunction() = FunSpec.builder("deauthorize")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        @param accessToken Responds with the refresh tokens that were revoked.
        """.trimIndent()
    )
    .addAnnotation(FormUrlEncoded::class)
    .addAnnotation(
        AnnotationSpec.builder(POST::class)
            .addMember("%S", "oauth/deauthorize")
            .build()
    )
    .addParameter(fieldParam("accessToken", "access_token", string))
