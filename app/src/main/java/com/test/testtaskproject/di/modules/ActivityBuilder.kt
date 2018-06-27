package com.test.testtaskproject.di.modules

import com.test.testtaskproject.ui.login.LoginActivity
import com.test.testtaskproject.ui.login.LoginActivityModule
import com.test.testtaskproject.ui.worlds.WorldActivity
import com.test.testtaskproject.ui.worlds.WorldActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [WorldActivityModule::class])
    abstract fun bindWorldActivity(): WorldActivity

}