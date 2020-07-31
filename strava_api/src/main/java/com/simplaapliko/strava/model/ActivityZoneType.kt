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

enum class ActivityZoneType(private val id: String) {
    HEART_RATE("heartrate"), POWER("power");

    companion object {
        fun byId(id: String): ActivityZoneType {
            for (frameType in values()) {
                if (frameType.id == id) {
                    return frameType
                }
            }
            throw IllegalArgumentException("unknown id: $id")
        }
    }

    override fun toString(): String {
        return id
    }
}