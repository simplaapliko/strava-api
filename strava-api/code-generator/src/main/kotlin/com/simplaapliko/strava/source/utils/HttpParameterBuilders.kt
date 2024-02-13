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

package com.simplaapliko.strava.source.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Path
import retrofit2.http.Query

fun bodyParam(
    name: String,
    typeName: TypeName,
): ParameterSpec {
    val annotation = AnnotationSpec.builder(Body::class)
        .build()

    val builder = ParameterSpec.builder(name, typeName)
        .addAnnotation(annotation)

    return builder.build()
}

fun fieldParam(
    name: String,
    annotationName: String,
    typeName: TypeName,
    defaultValue: Any? = null
): ParameterSpec {
    val annotation = AnnotationSpec.builder(Field::class)
        .addMember("%S", annotationName)
        .build()

    val builder = ParameterSpec.builder(name, typeName)
        .addAnnotation(annotation)

    defaultValue?.let { builder.defaultValue("%S", it) }

    return builder.build()
}

fun pathParam(
    name: String,
    annotationName: String,
    typeName: TypeName,
    defaultValue: Any? = null
): ParameterSpec {
    val annotation = AnnotationSpec.builder(Path::class)
        .addMember("%S", annotationName)
        .build()

    val builder = ParameterSpec.builder(name, typeName)
        .addAnnotation(annotation)

    defaultValue?.let { builder.defaultValue("%S", it) }

    return builder.build()
}

fun queryParam(
    name: String,
    annotationName: String,
    typeName: TypeName,
): ParameterSpec {
    val annotation = AnnotationSpec.builder(Query::class)
        .addMember("%S", annotationName)
        .build()

    return ParameterSpec.builder(name, typeName)
        .addAnnotation(annotation)
        .build()
}

fun queryParam(
    name: String,
    annotationName: String,
    typeName: TypeName,
    defaultValue: Any? = null
): ParameterSpec {
    val annotation = AnnotationSpec.builder(Query::class)
        .addMember("%S", annotationName)
        .build()

    return ParameterSpec.builder(name, typeName)
        .addAnnotation(annotation)
        .defaultValue("%L", defaultValue)
        .build()
}
