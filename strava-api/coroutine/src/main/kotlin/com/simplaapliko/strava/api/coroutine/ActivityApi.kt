// Generated code, do not modify.
package com.simplaapliko.strava.api.coroutine

import com.simplaapliko.strava.model.Activity
import com.simplaapliko.strava.model.ActivityZone
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.Comment
import com.simplaapliko.strava.model.Lap
import com.simplaapliko.strava.model.Photo
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.strava.model.UpdatableActivity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

public interface ActivityApi {
    /**
     * Returns the activities of an athlete for a specific identifier.
     * Requires activity:read.
     * Only Me activities will be filtered out unless requested by a token with activity:read_all.
     *
     * @param before An epoch timestamp to use for filtering activities
     *                  that have taken place before a certain time.
     * @param after An epoch timestamp to use for filtering activities
     *                  that have taken place after a certain time.
     * @param page Page number. Defaults to 1.
     * @param perPage Number of items per page. Defaults to 30.
     */
    @GET("athlete/activities")
    public suspend fun getActivities(
        @Query("before") before: Int? = null,
        @Query("after") after: Int? = null,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
    ): StravaResponse<List<Activity>>

    /**
     * Creates a manual activity for an athlete.
     * Requires activity:write scope.
     *
     * @param name The name of the activity.
     * @param type Type of activity. For example - Run, Ride etc.
     *   deprecated, use sportType
     *   @see com.simplaapliko.strava.model.ActivityType
     * @param sportType Sport type of activity. For example - Run, MountainBikeRide, Ride, etc.
     *   @see com.simplaapliko.strava.model.SportType
     * @param startDateLocal ISO 8601 formatted date time.
     * @param elapsedTime In seconds.
     * @param description Description of the activity.
     * @param distance In meters.
     * @param trainer Set to 1 to mark as a trainer activity.
     * @param commute Set to 1 to mark as commute.
     */
    @POST("activities")
    public suspend fun createActivity(
        @Query("name") name: String,
        @Query("type") type: String? = null,
        @Query("sport_type") sportType: String,
        @Query("start_date_local") startDateLocal: String,
        @Query("elapsed_time") elapsedTime: Int,
        @Query("description") description: String? = null,
        @Query("distance") distance: Float? = null,
        @Query("trainer") trainer: Int? = null,
        @Query("commute") commute: Int? = null,
    ): StravaResponse<Activity>

    /**
     * Returns the given activity that is owned by the authenticated athlete.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     */
    @GET("activities/{id}")
    public suspend fun getActivity(@Path("id") id: Long): StravaResponse<Activity>

    /**
     * Returns the comments on the given activity.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     * @param page Page number. Defaults to 1.
     * @param perPage Number of items per page. Defaults to 30.
     */
    @GET("activities/{id}/comments")
    public suspend fun getActivityComments(
        @Path("id") id: Long,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
    ): StravaResponse<List<Comment>>

    /**
     * Returns the athletes who kudoed an activity identified by an identifier.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     * @param page Page number. Defaults to 1.
     * @param perPage Number of items per page. Defaults to 30.
     */
    @GET("activities/{id}/kudos")
    public suspend fun getActivityKudos(
        @Path("id") id: Long,
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null,
    ): StravaResponse<List<Athlete>>

    /**
     * Returns the laps of an activity identified by an identifier.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     */
    @GET("activities/{id}/laps")
    public suspend fun getActivityLaps(@Path("id") id: Long): StravaResponse<List<Lap>>

    /**
     * Returns photos of an activity identified by an identifier.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     * @param size The size of the photo, default value 5000.
     */
    @GET("activities/{id}/photos")
    public suspend fun getActivityPhotos(@Path("id") id: Long, @Query("size") size: Int = 5_000):
            StravaResponse<List<Photo>>

    /**
     * Summit Feature. Returns the zones of a given activity.
     * Requires activity:read for Everyone and Followers activities.
     * Requires activity:read_all for Only Me activities.
     *
     * @param id The identifier of the activity.
     */
    @GET("activities/{id}/zones")
    public suspend fun getActivityZones(@Path("id") id: Long): StravaResponse<List<ActivityZone>>

    /**
     * Updates the given activity that is owned by the authenticated athlete.
     * Requires activity:write.
     * Also requires activity:read_all in order to update Only Me activities
     *
     * @param id The identifier of the activity.
     */
    @PUT("activities/{id}")
    public suspend fun updateActivity(@Path("id") id: Long, @Body body: UpdatableActivity):
            StravaResponse<Activity>
}
