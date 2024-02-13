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

import com.simplaapliko.strava.source.utils.unit
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import io.reactivex.Completable
import io.reactivex.Single

private val completable = ClassName(Completable::class.java.packageName, Completable::class.simpleName!!)
private val single = ClassName(Single::class.java.packageName, Single::class.simpleName!!)

private fun singleOf(type: TypeName) = single.parameterizedBy(type)

object RxJava2Framework : Framework {

    override fun generateFile(
        apiName: String,
        mapOfFunctions: Map<() -> FunSpec.Builder, TypeName>,
    ) {
        val functions = mapOfFunctions.map { entry ->
            entry.key().asRxJava2Function(entry.value)
        }

        generateFile("rxjava2", apiName, functions)
    }

    private fun FunSpec.Builder.asRxJava2Function(
        returnType: TypeName,
    ): FunSpec {
        val type = if (returnType == unit) {
            completable
        } else {
            singleOf(returnType)
        }

        return this
            .returns(type)
            .build()
    }
}
