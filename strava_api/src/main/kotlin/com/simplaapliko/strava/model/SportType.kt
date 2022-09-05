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
 * An enumeration of the sport types an activity may have.
 * Distinct from ActivityType in that it has new types (e.g. MountainBikeRide)
 * @see ActivityType
 */
enum class SportType(val id: String) {
    ALPINE_SKI("AlpineSki"),
    BACKCOUNTRY_SKI("BackcountrySki"),
    CANOEING("Canoeing"),
    CROSSFIT("Crossfit"),
    EBIKE_RIDE("EBikeRide"),
    ELLIPTICAL("Elliptical"),
    EMOUNTAIN_BIKE_RIDE("EMountainBikeRide"),
    GOLF("Golf"),
    GRAVEL_RIDE("GravelRide"),
    HANDCYCLE("Handcycle"),
    HIKE("Hike"),
    ICE_SKATE("IceSkate"),
    INLINE_SKATE("InlineSkate"),
    KAYAKING("Kayaking"),
    KITESURF("Kitesurf"),
    MOUNTAIN_BIKE_RIDE("MountainBikeRide"),
    NORDIC_SKI("NordicSki"),
    RIDE("Ride"),
    ROCK_CLIMBING("RockClimbing"),
    ROLLER_SKI("RollerSki"),
    ROWING("Rowing"),
    RUN("Run"),
    SAIL("Sail"),
    SKATEBOARD("Skateboard"),
    SNOWBOARD("Snowboard"),
    SNOWSHOE("Snowshoe"),
    SOCCER("Soccer"),
    STAIRSTEPPER("StairStepper"),
    STANDUP_PADDLING("StandUpPaddling"),
    SURFING("Surfing"),
    SWIM("Swim"),
    TRAIL_RUN("TrailRun"),
    VELOMOBILE("Velomobile"),
    VIRTUAL_RIDE("VirtualRide"),
    VIRTUAL_RUN("VirtualRun"),
    WALK("Walk"),
    WEIGHT_TRAINING("WeightTraining"),
    WHEELCHAIR("Wheelchair"),
    WINDSURF("Windsurf"),
    WORKOUT("Workout"),
    YOGA("Yoga");

    companion object {
        fun byId(id: String): SportType? = values().firstOrNull { it.id == id }
    }
}
