package com.test.testtaskproject.prefs

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.test.testtaskproject.model.user.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
private const val USER_KEY = "USER_KEY"
private const val NO_USER = "NO_USER"

@Singleton
class UserPreferencesImpl @Inject constructor(val sp: SharedPreferences): UserPreferences<User> {

    override fun saveUser(model: User) {
        val userToJson = Gson().toJson(model)
        sp.edit().putString(USER_KEY, userToJson).apply()
    }

    override fun getUser(): User? {
        val jsonUser = sp.getString(USER_KEY, NO_USER)
        var user: User? = null
        if(!jsonUser.equals(NO_USER)){
            try {
                user = Gson().fromJson(jsonUser, User::class.java)
            } catch (e: JsonSyntaxException){
                e.printStackTrace()
            }
        }
        return user
    }

    override fun isLogin(): Boolean = getUser() != null

    override fun logout() {
        sp.edit().clear().apply()
    }

}