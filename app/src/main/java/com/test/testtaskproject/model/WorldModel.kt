package com.test.testtaskproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldModel {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("worldStatus")
    @Expose
    var worldStatus: WorldStatus? = null

    @SerializedName("mapURL")
    @Expose
    var mapURL: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

}