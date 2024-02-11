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

enum class AchievementType(val id: Int, val type: String) {
    OVERALL(2, "overall"),
    PR(3, "pr"),
    LOCAL_LEGEND(7, "segment_effort_count_leader");

    companion object {
        fun byId(id: Int): AchievementType? {
            return values().firstOrNull { it.id == id }
        }

        fun byType(type: String): AchievementType? {
            return values().firstOrNull { it.type == type }
        }
    }
}
