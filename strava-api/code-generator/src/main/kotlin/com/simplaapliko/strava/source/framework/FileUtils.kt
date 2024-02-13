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

package com.simplaapliko.strava.source.framework

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

private const val PACKAGE = "com.simplaapliko.strava.api"
private const val ROOT_MODULE = "strava-api"
private const val PATH = "src/main/kotlin"

fun generateFile(module: String, interfaceName: String, functions: List<FunSpec>) {
    val file = FileSpec.builder("$PACKAGE.$module", interfaceName)
        .indent(" ".repeat(4))
        .addFileComment("Generated code, do not modify.")
        .addType(
            TypeSpec.interfaceBuilder(interfaceName)
                .addFunctions(functions)
                .build()
        )
        .build()

    val filePath = File("$ROOT_MODULE/$module/$PATH")

    file.writeTo(filePath)
}
