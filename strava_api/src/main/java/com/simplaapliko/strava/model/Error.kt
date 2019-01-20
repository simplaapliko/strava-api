package com.simplaapliko.strava.model

import com.squareup.moshi.Json

data class Error(
    /**
     * The code associated with this error.
     */
    @Json(name ="code")
    var code: String = "",

    /**
     * The specific field or aspect of the resource associated with this error.
     */
    @Json(name ="field")
    var field: String = "",

    /**
     * The type of resource associated with this error.
     */
    @Json(name ="resource")
    var resource: String = ""
)
