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
import com.simplaapliko.strava.source.utils.activityStats
import com.simplaapliko.strava.source.utils.athlete
import com.simplaapliko.strava.source.utils.double
import com.simplaapliko.strava.source.utils.long
import com.simplaapliko.strava.source.utils.pathParam
import com.simplaapliko.strava.source.utils.queryParam
import com.simplaapliko.strava.source.utils.responseOf
import com.simplaapliko.strava.source.utils.zones
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import retrofit2.http.GET
import retrofit2.http.PUT

private const val INTERFACE_NAME = "AthleteApi"

fun generateAthleteApiFiles() {
    val mapOfFunctions = mapOf(
        { getAthleteStatsFunction() } to responseOf(activityStats),
        { getAuthenticatedAthleteFunction() } to responseOf(athlete),
        { getZonesFunction() } to responseOf(zones),
        { updateAthleteFunction() } to responseOf(athlete),
    )

    generateFiles(INTERFACE_NAME, mapOfFunctions)
}

private fun getAthleteStatsFunction() = FunSpec.builder("getAthleteStats")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the activity stats of an athlete.
        
        @param id The identifier of the athlete. Must match the authenticated athlete.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "athletes/{id}/stats")
            .build()
    )
    .addParameter(pathParam("id", "id", long))

private fun getAuthenticatedAthleteFunction() = FunSpec.builder("getAuthenticatedAthlete")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the currently authenticated athlete.
        Tokens with profile:read_all scope will receive a detailed athlete representation;
        all others will receive a summary representation.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "athlete")
            .build()
    )

private fun getZonesFunction() = FunSpec.builder("getZones")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the the authenticated athlete’s heart rate and power zones.
        Requires profile:read_all.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "athlete/zones")
            .build()
    )

private fun updateAthleteFunction() = FunSpec.builder("updateAthlete")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Update the currently authenticated athlete.
        Requires profile:write scope.
        
        @param weight The weight of the athlete in kilograms.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(PUT::class)
            .addMember("%S", "athlete")
            .build()
    )
    .addParameter(queryParam("weight", "weight", double))
