// Generated code, do not modify.
package com.simplaapliko.strava.api.rxjava2

import com.simplaapliko.strava.model.ActivityStats
import com.simplaapliko.strava.model.Athlete
import com.simplaapliko.strava.model.StravaResponse
import com.simplaapliko.strava.model.Zones
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

public interface AthleteApi {
    /**
     * Returns the activity stats of an athlete.
     *
     * @param id The identifier of the athlete. Must match the authenticated athlete.
     */
    @GET("athletes/{id}/stats")
    public fun getAthleteStats(@Path("id") id: Long): Single<StravaResponse<ActivityStats>>

    /**
     * Returns the currently authenticated athlete.
     * Tokens with profile:read_all scope will receive a detailed athlete representation;
     * all others will receive a summary representation.
     */
    @GET("athlete")
    public fun getAuthenticatedAthlete(): Single<StravaResponse<Athlete>>

    /**
     * Returns the the authenticated athlete’s heart rate and power zones.
     * Requires profile:read_all.
     */
    @GET("athlete/zones")
    public fun getZones(): Single<StravaResponse<Zones>>

    /**
     * Update the currently authenticated athlete.
     * Requires profile:write scope.
     *
     * @param weight The weight of the athlete in kilograms.
     */
    @PUT("athlete")
    public fun updateAthlete(@Query("weight") weight: Double): Single<StravaResponse<Athlete>>
}
