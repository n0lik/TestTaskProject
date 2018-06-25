package com.test.testtaskproject.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.test.testtaskproject.model.WorldModel

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class UserWorldsResponse {

    @SerializedName("serverVersion")
    @Expose
    var serverVersion: String? = null

    @SerializedName("allAvailableWorlds")
    @Expose
    var availableWorlds: List<WorldModel>? = null

}