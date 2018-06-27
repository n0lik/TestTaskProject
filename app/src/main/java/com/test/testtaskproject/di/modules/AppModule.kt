package com.test.testtaskproject.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.prefs.UserPreferences
import com.test.testtaskproject.prefs.UserPreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        @Named("pref")
        fun providePrefName() = "TEST_TASK_APP"


        @JvmStatic
        @Provides
        @Singleton
        fun provideSharedPreferences(context: Context, @Named("pref") name: String): SharedPreferences {
            return context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideUserPreferences(up: UserPreferencesImpl<User>): UserPreferences<User> = up
    }
}