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

import com.simplaapliko.strava.model.Activity
import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.ActivityZone
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Comment
import com.simplaapliko.strava.model.Gear
import com.simplaapliko.strava.model.Lap
import com.simplaapliko.strava.model.Photo
import com.simplaapliko.strava.model.RefreshToken
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.strava.model.Token
import com.simplaapliko.strava.model.Zones
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.asTypeName

fun ClassName.asNullable() = this.copy(nullable = true)

val int = Int::class.asTypeName()
val double = Double::class.asTypeName()
val float = Float::class.asTypeName()
val long = Long::class.asTypeName()
val string = String::class.asTypeName()

val list = ClassName("kotlin.collections", "List")

val activity = ClassName(Activity::class.java.packageName, Activity::class.simpleName!!)
val activityStats = ClassName(ActivityStats::class.java.packageName, ActivityStats::class.simpleName!!)
val activityZone = ClassName(ActivityZone::class.java.packageName, ActivityZone::class.simpleName!!)
val athlete = ClassName(Athlete::class.java.packageName, Athlete::class.simpleName!!)
val comment = ClassName(Comment::class.java.packageName, Comment::class.simpleName!!)
val gear = ClassName(Gear::class.java.packageName, Gear::class.simpleName!!)
val lap = ClassName(Lap::class.java.packageName, Lap::class.simpleName!!)
val photo = ClassName(Photo::class.java.packageName, Photo::class.simpleName!!)
val refreshToken = ClassName(RefreshToken::class.java.packageName, RefreshToken::class.simpleName!!)
val response = ClassName(StravaResponse::class.java.packageName, StravaResponse::class.simpleName!!)
val token = ClassName(Token::class.java.packageName, Token::class.simpleName!!)
val zones = ClassName(Zones::class.java.packageName, Zones::class.simpleName!!)
val unit = ClassName(Unit::class.java.packageName, Unit::class.simpleName!!)

fun listOf(type: ClassName) = list.parameterizedBy(type)
fun responseOf(type: ClassName) = response.parameterizedBy(type)
fun responseOfList(type: ClassName) = response.parameterizedBy(listOf(type))
