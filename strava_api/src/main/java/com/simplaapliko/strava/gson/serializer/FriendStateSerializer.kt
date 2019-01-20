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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.simplaapliko.strava.model.FriendState
import java.lang.reflect.Type

class FriendStateSerializer : JsonDeserializer<FriendState>, JsonSerializer<FriendState> {

    override fun deserialize(
        json: JsonElement, typeOfT: Type, context: JsonDeserializationContext
    ): FriendState {
        return FriendState.byId(json.asString)
    }

    override fun serialize(
        src: FriendState, typeOfSrc: Type, context: JsonSerializationContext
    ): JsonElement {
        return context.serialize(src.id)
    }
}
