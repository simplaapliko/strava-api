package com.simplaapliko.strava.model

import com.google.gson.annotations.SerializedName

abstract class StravaResponse {
    /**
     * The set of specific errors associated with this fault, if any.
     */
    @SerializedName("errors")
    var errors: List<Error>? = null

    /**
     * The message of the fault.
     */
    @SerializedName("message")
    var errorMessage: String? = null
}
