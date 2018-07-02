package com.test.testtaskproject.ui.worlds

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sergey Shvets on 02/07/2018.
 */
@Module
abstract class WorldFragmentProvider {

        @ContributesAndroidInjector(modules = [WorldFragmentModule::class])
        abstract fun bindWorldFragment(): WorldFragment

}