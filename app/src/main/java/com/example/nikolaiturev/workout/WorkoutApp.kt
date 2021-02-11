package com.example.nikolaiturev.workout

import android.app.Application
import com.example.nikolaiturev.workout.di.adapterModule
import com.example.nikolaiturev.workout.di.mapperModule
import com.example.nikolaiturev.workout.di.repositoryModule
import com.example.nikolaiturev.workout.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WorkoutApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            this.modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    mapperModule,
                    adapterModule
                )
            )
            this.androidContext(this@WorkoutApp)
        }
    }
}