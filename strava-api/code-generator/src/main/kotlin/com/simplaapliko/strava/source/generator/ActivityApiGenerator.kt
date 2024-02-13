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

package com.simplaapliko.strava.source.generator

import com.simplaapliko.strava.model.UpdatableActivity
import com.simplaapliko.strava.source.generateFiles
import com.simplaapliko.strava.source.utils.activity
import com.simplaapliko.strava.source.utils.activityZone
import com.simplaapliko.strava.source.utils.asNullable
import com.simplaapliko.strava.source.utils.athlete
import com.simplaapliko.strava.source.utils.bodyParam
import com.simplaapliko.strava.source.utils.comment
import com.simplaapliko.strava.source.utils.float
import com.simplaapliko.strava.source.utils.int
import com.simplaapliko.strava.source.utils.lap
import com.simplaapliko.strava.source.utils.long
import com.simplaapliko.strava.source.utils.pathParam
import com.simplaapliko.strava.source.utils.photo
import com.simplaapliko.strava.source.utils.queryParam
import com.simplaapliko.strava.source.utils.responseOf
import com.simplaapliko.strava.source.utils.responseOfList
import com.simplaapliko.strava.source.utils.string
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asTypeName
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

private const val INTERFACE_NAME = "ActivityApi"

fun generateActivityApiFiles() {
    val mapOfFunctions = mapOf(
        { getActivitiesFunction() } to responseOfList(activity),
        { createActivityFunction() } to responseOf(activity),
        { getActivityFunction() } to responseOf(activity),
        { getActivityCommentsFunction() } to responseOfList(comment),
        { getActivityKudosFunction() } to responseOfList(athlete),
        { getActivityLapsFunction() } to responseOfList(lap),
        { getActivityPhotosFunction() } to responseOfList(photo),
        { getActivityZonesFunction() } to responseOfList(activityZone),
        { updateActivityFunction() } to responseOf(activity),
    )

    generateFiles(INTERFACE_NAME, mapOfFunctions)
}


private fun getActivitiesFunction() = FunSpec.builder("getActivities")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the activities of an athlete for a specific identifier.
        Requires activity:read.
        Only Me activities will be filtered out unless requested by a token with activity:read_all.
        
        @param before An epoch timestamp to use for filtering activities
                         that have taken place before a certain time.
        @param after An epoch timestamp to use for filtering activities
                         that have taken place after a certain time.
        @param page Page number. Defaults to 1.
        @param perPage Number of items per page. Defaults to 30.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "athlete/activities")
            .build()
    )
    .addParameter(queryParam("before", "before", int.asNullable(), null))
    .addParameter(queryParam("after", "after", int.asNullable(), null))
    .addParameter(queryParam("page", "page", int.asNullable(), null))
    .addParameter(queryParam("perPage", "per_page", int.asNullable(), null))

private fun createActivityFunction() = FunSpec.builder("createActivity")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Creates a manual activity for an athlete.
        Requires activity:write scope.
        
        @param name The name of the activity.
        @param type Type of activity. For example - Run, Ride etc.
          deprecated, use sportType
          @see com.simplaapliko.strava.model.ActivityType
        @param sportType Sport type of activity. For example - Run, MountainBikeRide, Ride, etc.
          @see com.simplaapliko.strava.model.SportType
        @param startDateLocal ISO 8601 formatted date time.
        @param elapsedTime In seconds.
        @param description Description of the activity.
        @param distance In meters.
        @param trainer Set to 1 to mark as a trainer activity.
        @param commute Set to 1 to mark as commute.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(POST::class)
            .addMember("%S", "activities")
            .build()
    )
    .addParameter(queryParam("name", "name", string))
    .addParameter(queryParam("type", "type", string.asNullable(), null))
    .addParameter(queryParam("sportType", "sport_type", string))
    .addParameter(queryParam("startDateLocal", "start_date_local", string))
    .addParameter(queryParam("elapsedTime", "elapsed_time", int))
    .addParameter(queryParam("description", "description", string.asNullable(), null))
    .addParameter(queryParam("distance", "distance", float.asNullable(), null))
    .addParameter(queryParam("trainer", "trainer", int.asNullable(), null))
    .addParameter(queryParam("commute", "commute", int.asNullable(), null))

private fun getActivityFunction() = FunSpec.builder("getActivity")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the given activity that is owned by the authenticated athlete.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}")
            .build()
    )
    .addParameter(pathParam("id", "id", long))

private fun getActivityCommentsFunction() = FunSpec.builder("getActivityComments")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the comments on the given activity.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        @param page Page number. Defaults to 1.
        @param perPage Number of items per page. Defaults to 30.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}/comments")
            .build()
    )
    .addParameter(pathParam("id", "id", long))
    .addParameter(queryParam("page", "page", int.asNullable(), null))
    .addParameter(queryParam("perPage", "per_page", int.asNullable(), null))

private fun getActivityKudosFunction() = FunSpec.builder("getActivityKudos")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the athletes who kudoed an activity identified by an identifier.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        @param page Page number. Defaults to 1.
        @param perPage Number of items per page. Defaults to 30.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}/kudos")
            .build()
    )
    .addParameter(pathParam("id", "id", long))
    .addParameter(queryParam("page", "page", int.asNullable(), null))
    .addParameter(queryParam("perPage", "per_page", int.asNullable(), null))

private fun getActivityLapsFunction() = FunSpec.builder("getActivityLaps")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns the laps of an activity identified by an identifier.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}/laps")
            .build()
    )
    .addParameter(pathParam("id", "id", long))

private fun getActivityPhotosFunction() = FunSpec.builder("getActivityPhotos")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Returns photos of an activity identified by an identifier.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        @param size The size of the photo, default value 5000.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}/photos")
            .build()
    )
    .addParameter(pathParam("id", "id", long))
    .addParameter(queryParam("size", "size", int, 5_000))

private fun getActivityZonesFunction() = FunSpec.builder("getActivityZones")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Summit Feature. Returns the zones of a given activity.
        Requires activity:read for Everyone and Followers activities.
        Requires activity:read_all for Only Me activities.
        
        @param id The identifier of the activity.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(GET::class)
            .addMember("%S", "activities/{id}/zones")
            .build()
    )
    .addParameter(pathParam("id", "id", long))

private fun updateActivityFunction() = FunSpec.builder("updateActivity")
    .addModifiers(KModifier.ABSTRACT)
    .addKdoc(
        """
        Updates the given activity that is owned by the authenticated athlete.
        Requires activity:write.
        Also requires activity:read_all in order to update Only Me activities
        
        @param id The identifier of the activity.
        """.trimIndent()
    )
    .addAnnotation(
        AnnotationSpec.builder(PUT::class)
            .addMember("%S", "activities/{id}")
            .build()
    )
    .addParameter(pathParam("id", "id", long))
    .addParameter(bodyParam("body", UpdatableActivity::class.asTypeName()))
