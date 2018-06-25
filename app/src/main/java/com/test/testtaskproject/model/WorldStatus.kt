package com.test.testtaskproject.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class WorldStatus {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

}