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
import com.simplaapliko.strava.source.utils.gear
import com.simplaapliko.strava.source.utils.pathParam
import com.simplaapliko.strava.source.utils.responseOf
import com.simplaapliko.strava.source.utils.string
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import retrofit2.http.GET

private const val INTERFACE_NAME = "GearApi"

fun generateGearApiFiles() {
    val mapOfFunctions = mapOf(
        { getGearFunction() } to responseOf(gear)
    )

    generateFiles(INTERFACE_NAME, mapOfFunctions)
}

private fun getGearFunction() = FunSpec.builder("getGear")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns an equipment using its identifier.
        
        @param id The identifier of the gear.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "gear/{id}")
            .build()
    )
    .addParameter(pathParam("id", "id", string))
