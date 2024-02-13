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

package com.simplaapliko.strava.source

import com.simplaapliko.strava.source.framework.CoroutineFramework
import com.simplaapliko.strava.source.framework.Framework
import com.simplaapliko.strava.source.framework.RxJava2Framework
import com.simplaapliko.strava.source.generator.generateActivityApiFiles
import com.simplaapliko.strava.source.generator.generateAthleteApiFiles
import com.simplaapliko.strava.source.generator.generateGearApiFiles
import com.simplaapliko.strava.source.generator.generateTokenApiFiles
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeName

private val supportedFrameworks: List<Framework> = listOf(
    CoroutineFramework,
    RxJava2Framework,
)

fun generateFiles(
    apiName: String,
    mapOfFunctions: Map<() -> FunSpec.Builder, TypeName>,
) {
    supportedFrameworks.forEach { framework ->
        framework.generateFile(apiName, mapOfFunctions)
    }
}

fun main() {
    generateActivityApiFiles()
    generateAthleteApiFiles()
    generateTokenApiFiles()
    generateGearApiFiles()
}
