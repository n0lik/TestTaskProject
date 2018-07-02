package com.test.testtaskproject.ui.worlds

import com.test.testtaskproject.model.user.User
import com.test.testtaskproject.network.ServerApi
import com.test.testtaskproject.prefs.UserPreferences
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Shvets on 02/07/2018.
 */
@Module
class WorldFragmentModule {

    @Provides
    fun providePresenter(api: ServerApi, up: UserPreferences<User>): WorldPresenter = WorldPresenter(api, up)

}