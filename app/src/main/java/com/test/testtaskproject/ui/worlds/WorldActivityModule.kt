package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
@Module
class WorldActivityModule {

    @Provides
    fun providePresenter(api: ServerApi, up: UserPreferences<User>): WorldPresenter = WorldPresenter(api, up)

    @Provides
    fun provideWorldAdapter(): WorldAdapter = WorldAdapter()


}