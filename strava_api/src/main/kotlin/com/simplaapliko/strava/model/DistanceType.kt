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

package com.simplaapliko.strava.model

/**
 * A list of known distances.
 * Note: not from official documentation.
 */
enum class DistanceType(val id: String, val meters: Int) {
    METER_400("400m", 400),
    KM_1("1k", 1_000),
    KM_5("5k", 5_000),
    KM_10("10k", 10_000),
    KM_15("15k", 15_000),
    KM_20("20k", 20_000),
    KM_30("30k", 30_000),
    MILE_HALF("1/2 mile", 805),
    MILE_1("1 mile", 1_609),
    MILE_2("2 mile", 3_219),
    MILE_10("10 mile", 16_090),
    MARATHON_HALF("Half-Marathon", 21_097),
    MARATHON("Marathon", 42_195)
}
