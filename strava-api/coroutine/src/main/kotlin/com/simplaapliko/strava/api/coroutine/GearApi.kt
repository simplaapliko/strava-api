// Generated code, do not modify.
package com.simplaapliko.strava.api.coroutine

import com.simplaapliko.strava.model.Gear
import com.simplaapliko.strava.model.StravaResponse
import retrofit2.http.GET
import retrofit2.http.Path

public interface GearApi {
    /**
     * Returns an equipment using its identifier.
     *
     * @param id The identifier of the gear.
     */
    @GET("gear/{id}")
    public suspend fun getGear(@Path("id") id: String): StravaResponse<Gear>
}
