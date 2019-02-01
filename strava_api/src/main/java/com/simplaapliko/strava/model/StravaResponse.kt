package com.simplaapliko.strava.model

import com.squareup.moshi.Json

abstract class StravaResponse {
    /**
     * The set of specific errors associated with this fault, if any.
     */
    @Json(name = "errors")
    var errors: List<Error>? = null

    /**
     * The message of the fault.
     */
    @Json(name = "message")
    var errorMessage: String? = null
}
