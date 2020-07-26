package com.simplaapliko.strava.model

import com.google.gson.annotations.SerializedName

data class Error(
    /**
     * The code associated with this error.
     */
    @SerializedName("code")
    var code: String = "",

    /**
     * The specific field or aspect of the resource associated with this error.
     */
    @SerializedName("field")
    var field: String = "",

    /**
     * The type of resource associated with this error.
     */
    @SerializedName("resource")
    var resource: String = ""
)
