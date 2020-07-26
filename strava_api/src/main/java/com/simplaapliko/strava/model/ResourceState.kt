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

enum class ResourceState(val id: Int?) {
    UNKNOWN(null), META(1), SUMMARY(2), DETAIL(3);

    companion object {
        fun byId(id: Int): ResourceState {
            for (frameType in values()) {
                if (frameType.id == id) {
                    return frameType
                }
            }
            return UNKNOWN
        }
    }
}
