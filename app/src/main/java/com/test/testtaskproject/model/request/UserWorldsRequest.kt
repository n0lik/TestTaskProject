package com.test.testtaskproject.model.request

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
data class UserWorldsRequest(val email: String,
                             val pass: String,
                             val deviceType: String,
                             val deviceId: String)