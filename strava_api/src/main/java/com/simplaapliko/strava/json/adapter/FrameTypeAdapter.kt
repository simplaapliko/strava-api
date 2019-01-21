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

package com.simplaapliko.strava.json.adapter

import com.simplaapliko.strava.model.FrameType
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class FrameTypeAdapter : JsonAdapter<FrameType>() {

    override fun fromJson(reader: JsonReader): FrameType {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Unit>()
            FrameType.UNKNOWN
        } else {
            FrameType.byId(reader.nextInt())
        }
    }

    override fun toJson(writer: JsonWriter, value: FrameType?) {
        writer.value(value?.id)
    }
}
