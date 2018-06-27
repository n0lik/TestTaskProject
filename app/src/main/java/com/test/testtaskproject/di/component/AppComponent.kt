package com.test.testtaskproject.di.component

import android.app.Application
import com.test.testtaskproject.di.TestTaskApp
import com.test.testtaskproject.di.modules.ActivityBuilder
import com.test.testtaskproject.di.modules.ApiModule
import com.test.testtaskproject.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

/**
 * Created by Sergey Shvets on 25/06/2018.
 */
@Singleton
@Component(modules = [ApiModule::class, AppModule::class, AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: TestTaskApp)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent

    }

}