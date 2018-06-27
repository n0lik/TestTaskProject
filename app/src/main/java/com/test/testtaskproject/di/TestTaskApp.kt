package com.test.testtaskproject.di

import com.test.testtaskproject.di.component.AppComponent
import com.test.testtaskproject.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dagger.android.support.DaggerApplication_MembersInjector

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
class TestTaskApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: AppComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

}