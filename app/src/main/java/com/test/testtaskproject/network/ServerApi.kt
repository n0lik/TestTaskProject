package com.test.testtaskproject.network

import com.test.testtaskproject.model.response.UserWorldsResponse
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Sergey Shvets on 25/06/2018.
 */

private const val USER_WORLD_URL = "/XYRALITY/WebObjects/BKLoginServer.woa/wa/worlds"

interface ServerApi {

    @FormUrlEncoded
    @POST(USER_WORLD_URL)
    @Headers("Accept: application/json")
    fun getUserWorlds(@FieldMap map: HashMap<String, String>): Observable<UserWorldsResponse>

}