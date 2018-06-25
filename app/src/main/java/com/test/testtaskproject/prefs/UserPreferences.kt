package com.test.testtaskproject.prefs

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
interface UserPreferences<T> {

    fun getUser(): T?

    fun saveUser(model: T): Boolean

}