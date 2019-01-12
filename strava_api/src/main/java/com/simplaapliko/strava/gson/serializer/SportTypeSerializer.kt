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

package com.simplaapliko.strava.gson.serializer

import com.google.gson.*
import com.simplaapliko.strava.model.SportType
import java.lang.reflect.Type

class SportTypeSerializer : JsonDeserializer<SportType>, JsonSerializer<SportType> {

    override fun deserialize(
        json: JsonElement, typeOfT: Type, context: JsonDeserializationContext
    ): SportType {
        return SportType.byId(json.asString)
    }

    override fun serialize(
        src: SportType, typeOfSrc: Type, context: JsonSerializationContext
    ): JsonElement {
        return context.serialize(src.id)
    }
}
